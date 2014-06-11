package de.cbos.dao.page;

import de.cbos.model.page.Page;

public interface PageDAO {
	
	public void addPage(Page page);
	public Page getPage(int pageId);
	public void deletePage(Page page);
	public void updatePage(Page page);

}
