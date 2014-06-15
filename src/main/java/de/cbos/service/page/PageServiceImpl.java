package de.cbos.service.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.cbos.dao.page.PageDAO;
import de.cbos.model.module.Module;
import de.cbos.model.page.Page;

public class PageServiceImpl implements PageService {

	@Autowired
	private PageDAO pageDAO;
	
	public String addPage(Page page) {
		return pageDAO.addPage(page);
	}
	
	public Page getPage(String pageName) {
		return pageDAO.getPage(pageName);
	}
	
	public List<Page> getPageList() {
		return pageDAO.getPageList();
	}
	
	public void deletePage(Page page) {
		pageDAO.deletePage(page);
	}
	
	public void updatePage(Page page) {
		pageDAO.updatePage(page);
	}
	
	public void addModule(Module module, Page page) {
		pageDAO.addModule(module, page);
	}
}
