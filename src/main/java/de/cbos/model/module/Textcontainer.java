package de.cbos.model.module;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "textcontainers")
@PrimaryKeyJoinColumn(name = "moduleId")
public class Textcontainer extends Module {

	private String headline;
	
	
	public Textcontainer() {
		setType("textcontainer");
	}
	
	public void accept(ModuleVisitor visitor) {
		visitor.visit(this);
	}
	
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public String getHeadline() {
		return this.headline;
	}
}
