package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import de.cbos.model.page.Page;

//@Entity
//@Table(name="links")
//@PrimaryKeyJoinColumn(name="contentId")
public class Link extends Content {
	
	private Page page;

	private String Link = this.page.getPageName();
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public String getLink() {
		return this.Link;
	}
}
