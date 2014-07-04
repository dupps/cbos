package de.cbos.model.page;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.engine.spi.CascadeStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

import de.cbos.model.content.Link;
import de.cbos.model.module.Module;

@Entity
@Table(name="pages")
public class Page {
	
	@Id
	@RegExp(value="[a-zA-Z0-9_-]*$")
	@NotNull
	@NotBlank
	private String pageName;

	@GeneratedValue
	@NotNull
	private int pageId;
	
	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	@OneToMany (cascade=CascadeType.REMOVE, orphanRemoval=true, mappedBy="page", fetch=FetchType.EAGER)
	@Fetch (value=FetchMode.SUBSELECT)
	private List<Module> modules = new ArrayList<Module>();
	
//	@OneToMany (mappedBy="page", fetch=FetchType.EAGER)
//	@Fetch (value=FetchMode.SUBSELECT)
//	private List<Link> links = new ArrayList<Link>();
	
//	public List<Link> getLinks() {
//		return links;
//	}
//
//	public void setLinks(List<Link> links) {
//		this.links = links;
//	}
	
	@OneToOne (cascade=CascadeType.REMOVE, mappedBy="page", fetch=FetchType.EAGER)
	private Link link;

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}
