package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import de.cbos.model.module.Navigation;
import de.cbos.model.page.Page;

@Entity
@Table(name="links")
@PrimaryKeyJoinColumn(name="contentId")
public class Link extends Content {
	
//	@ManyToOne (fetch=FetchType.EAGER)
//	@JoinColumn(name="pageName")
//	private Page page;

	private String link/* = this.page.getPageName()*/;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="moduleID")
	private Navigation navigation;
	
	public Navigation getNavigation() {
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}

//	public Page getPage() {
//		return page;
//	}
//
//	public void setPage(Page page) {
//		this.page = page;
//	}
	
	public String getLink() {
		return this.link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
}
