

package de.cbos.dao.page;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.content.Link;
import de.cbos.model.module.Guestbook;
import de.cbos.model.module.Module;
import de.cbos.model.module.ModuleVisitor;
import de.cbos.model.module.Navigation;
import de.cbos.model.module.Textcontainer;
import de.cbos.model.page.Page;
import de.cbos.service.content.ContentService;
import de.cbos.service.module.ModuleService;

@Transactional
public class PageDAOImpl implements PageDAO {

	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public String addPage(Page page) {
		if (!page.getPageName().equals("page")) {
			if (getPage(page.getPageName())!=null) {
				return "Page "+page.getPageName()+" already exists";
			} else {
				Link link = new Link();
				link.setPage(page);
				link.setLink(page.getPageName());
				page.setLink(link);
				contentService.addContent(link);
				getCurrentSession().save(page);
				return "Page "+page.getPageName()+" added successfully";
			}
		} else {
			return "'Page' is not a valid name";
		}
	}
	
	public Page getPage(String pageName) {
		Page page = (Page) getCurrentSession().get(Page.class, pageName);
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
		Page pageToUpdate = getPage(page.getPageName());
		pageToUpdate.setModules(page.getModules());
		pageToUpdate.setLink(page.getLink());
		getCurrentSession().update(pageToUpdate);
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
