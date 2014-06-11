package de.cbos.service.page;

import org.springframework.beans.factory.annotation.Autowired;

import de.cbos.dao.page.PageDAO;
import de.cbos.model.page.Page;

public class PageServiceImpl implements PageService {

	@Autowired
	private PageDAO pageDAO;
	
	public void addPage(Page page) {
		pageDAO.addPage(page);
	}
	
	public Page getPage(int pageId) {
		return pageDAO.getPage(pageId);
	}
	
	public void deletePage(Page page) {
		pageDAO.deletePage(page);
	}
	
	public void updatePage(Page page) {
		pageDAO.updatePage(page);
	}
}
