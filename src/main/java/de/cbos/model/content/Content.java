package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Entity
//@Table(name="content")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Content {
	
	@GeneratedValue
	private int contentId;
	
	private String contentType;
	
	public int getId() {
		return this.contentId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
