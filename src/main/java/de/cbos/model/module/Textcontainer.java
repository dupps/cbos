package de.cbos.model.module;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "textcontainers")
@PrimaryKeyJoinColumn(name = "moduleId")
public class Textcontainer extends Module {

	public Textcontainer() {
		setType("textfield");
	}
	
	private String headline;
	
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public String getHeadline() {
		return this.headline;
	}
}
