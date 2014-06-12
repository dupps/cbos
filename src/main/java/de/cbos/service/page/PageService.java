package de.cbos.service.page;

import java.util.List;

import de.cbos.model.module.Module;
import de.cbos.model.page.Page;

public interface PageService {

	public void addPage(Page page);
	public Page getPage(String pageName);
	public List<Page> getPageList();
	public void deletePage(Page page);
	public void updatePage(Page page);
	public void addModule(Module module, Page page);
}
