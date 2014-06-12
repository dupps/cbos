package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

import de.cbos.model.module.Guestbook;

@Entity
@Table(name="guestbookEntries")
@PrimaryKeyJoinColumn(name="contentId")
public class GuestbookEntry extends Content {
	
//	private User autor;
//	private Paragraph entry;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="moduleID")
	@NotNull
	private Guestbook guestbook;
	
	public GuestbookEntry() {
		setContentType("guestbookEntry");
	}
	
	public void accept(ContentVisitor visitor) {
		visitor.visit(this);
	}

	public Guestbook getGuestbook() {
		return guestbook;
	}

	public void setGuestbook(Guestbook guestbook) {
		this.guestbook = guestbook;
	}
	
//	public User getAutor() {
//		return autor;
//	}
//
//	public void setAutor(User autor) {
//		this.autor = autor;
//	}

//	public Paragraph getEntry() {
//		return entry;
//	}
//
//	public void setEntry(Paragraph entry) {
//		this.entry = entry;
//	}



}
