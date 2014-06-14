package de.cbos.model.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import de.cbos.model.content.Link;

@Entity
@Table(name = "navigations")
@PrimaryKeyJoinColumn(name = "moduleId")
public class Navigation extends Module  {

	@OneToMany (mappedBy="navigation", fetch=FetchType.EAGER)
	@Fetch (value=FetchMode.SUBSELECT)
	private List<Link> links = new ArrayList<Link>();
	
	private Boolean barLayout;
	
	public Navigation() {
		setType("navigation");
	}
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public Boolean getBarLayout() {
		return barLayout;
	}

	public void setBarLayout(Boolean barLayout) {
		this.barLayout = barLayout;
	}
}
