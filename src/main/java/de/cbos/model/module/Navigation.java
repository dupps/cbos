package de.cbos.model.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import de.cbos.model.content.Link;

//@Entity
//@Table(name = "navigations")
//@PrimaryKeyJoinColumn(name = "moduleId")
public class Navigation extends Module  {

	private List<Link> links = new ArrayList<Link>();
	
	public Navigation() {
		setType("navigation");
	}
	
	public List<Link> getLinkObjects() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public List<String> getLinks() {
		List<String> links = new ArrayList<String>();
		for(int i=0; i<=getLinkObjects().size(); i++) {
			links.add(getLinkObjects().get(i).getLink());
		}
		return links;
	}
}
