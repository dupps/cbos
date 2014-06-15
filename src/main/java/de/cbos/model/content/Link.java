package de.cbos.model.content;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

import de.cbos.model.module.Navigation;
import de.cbos.model.page.Page;

@Entity
@Table(name="links")
@PrimaryKeyJoinColumn(name="contentId")
public class Link extends Content {
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pageId")
	private Page page;
	
	private String link;

	public Link() {
		setContentType("link");
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public String getLink() {
		return this.link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void accept(ContentVisitor visitor) {
		visitor.visit(this);
	}
}
