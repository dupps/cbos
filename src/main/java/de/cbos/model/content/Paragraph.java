package de.cbos.model.content;

//@Entity
//@Table(name="paragraphs")
//@PrimaryKeyJoinColumn(name="contentId")
public class Paragraph extends Content {

	public Paragraph() {
		setContentType("paragraph");
	}
}
