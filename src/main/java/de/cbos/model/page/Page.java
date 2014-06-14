package de.cbos.model.page;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

import de.cbos.model.content.Link;
import de.cbos.model.module.Module;

@Entity
@Table(name="pages")
public class Page {
	
	@Id
	@NotNull
	@NotBlank
	private String pageName;

	@OneToMany (mappedBy="page", fetch=FetchType.EAGER)
	@Fetch (value=FetchMode.SUBSELECT)
	private List<Module> modules = new ArrayList<Module>();
	
//	@OneToMany (mappedBy="page", targetEntity=Link.class, fetch=FetchType.EAGER)
//	private List<Link> links = new ArrayList<Link>();
	
//	public List<Link> getLinks() {
//		return links;
//	}
//
//	public void setLinks(List<Link> links) {
//		this.links = links;
//	}

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
