package de.cbos.dao.page;

import java.util.List;

import de.cbos.model.module.Module;
import de.cbos.model.page.Page;

public interface PageDAO {
	
	public String addPage(Page page);
	public Page getPage(String pageName);
	public List<Page> getPageList();
	public void deletePage(Page page);
	public void updatePage(Page page);
	public void addModule(Module module, Page page);

}
