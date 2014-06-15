package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

import de.cbos.model.module.Textcontainer;

@Entity
@Table(name="paragraphs")
@PrimaryKeyJoinColumn(name="contentId")
public class Paragraph extends Content {

	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="moduleId")
	@NotNull
	private Textcontainer textcontainer;
	
	public Textcontainer getTextcontainer() {
		return textcontainer;
	}

	public void setTextcontainer(Textcontainer textcontainer) {
		this.textcontainer = textcontainer;
	}

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
