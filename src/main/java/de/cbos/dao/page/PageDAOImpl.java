package de.cbos.dao.page;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.module.Module;
import de.cbos.model.page.Page;
import de.cbos.service.module.ModuleService;

@Transactional
public class PageDAOImpl implements PageDAO {

	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addPage(Page page) {
		getCurrentSession().save(page);
	}
	
	public Page getPage(int pageId) {
		Page page = (Page) getCurrentSession().get(Page.class, pageId);
		return page;
	}
	
	@SuppressWarnings("unchecked")
	public List<Page> getPageList() {
		return getCurrentSession().createQuery("FROM Page").list();
	}
	
	public void deletePage(Page page) {
		getCurrentSession().delete(page);
	}
	
	public void updatePage(Page page) {
		Page pageToUpdate = getPage(page.getPageId());
		pageToUpdate.setModules(page.getModules());
		pageToUpdate.setPageName(page.getPageName());
	}
	
	public void addModule(Module module, Page page) {
		module.setPage(page);
		moduleService.addModule(module);
		List<Module> modules = page.getModules();
		modules.add(module);
		page.setModules(modules);
		updatePage(page);
	}
}
