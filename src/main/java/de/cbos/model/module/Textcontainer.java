package de.cbos.model.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import de.cbos.model.content.Paragraph;

@Entity
@Table(name = "textcontainers")
@PrimaryKeyJoinColumn(name = "moduleId")
public class Textcontainer extends Module {

	@OneToMany (cascade=CascadeType.REMOVE, orphanRemoval=true, mappedBy="textcontainer", fetch=FetchType.EAGER)
	@Fetch (value=FetchMode.SUBSELECT)
	private List<Paragraph> paragraphs = new ArrayList<Paragraph>();
	
	public Textcontainer() {
		setType("textcontainer");
	}
	
	public void accept(ModuleVisitor visitor) {
		visitor.visit(this);
	}

	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}
}
