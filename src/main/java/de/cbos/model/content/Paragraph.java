package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="paragraphs")
@PrimaryKeyJoinColumn(name="contentId")
public class Paragraph extends Content {

	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Paragraph() {
		setContentType("paragraph");
	}
	
	public void accept (ContentVisitor visitor) {
		visitor.visit(this);
	}
}
