package de.cbos.dao.page;

import java.util.List;

import de.cbos.model.module.Module;
import de.cbos.model.page.Page;

public interface PageDAO {
	
	public void addPage(Page page);
	public Page getPage(int pageId);
	public List<Page> getPageList();
	public void deletePage(Page page);
	public void updatePage(Page page);
	public void addModule(Module module, Page page);

}
