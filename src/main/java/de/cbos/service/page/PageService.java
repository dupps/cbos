package de.cbos.service.page;

import de.cbos.model.page.Page;

public interface PageService {

	public void addPage(Page page);
	public Page getPage(int pageId);
	public void deletePage(Page page);
	public void updatePage(Page page);
}
