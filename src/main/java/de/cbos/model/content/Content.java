package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="contents")
@Inheritance(strategy=InheritanceType.JOINED)
public class Content implements ContentEntity{
	
	@Id
	@GeneratedValue
	private int contentId;
	
	private String contentType;
	
	private String contentName;

	public void accept(ContentVisitor visitor) {
		
	}
	
	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

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
