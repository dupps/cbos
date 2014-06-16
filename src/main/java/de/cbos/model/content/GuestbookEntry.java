package de.cbos.model.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

import de.cbos.model.module.Guestbook;
import de.cbos.model.user.User;

@Entity
@Table(name="guestbookEntries")
@PrimaryKeyJoinColumn(name="contentId")
public class GuestbookEntry extends Content {
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="moduleId")
	@NotNull
	private Guestbook guestbook;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	@NotNull
	private User author;
	
	public GuestbookEntry() {
		setContentType("guestbookEntry");
	}
	
    @Column(columnDefinition="LONGVARCHAR")
	private String entry;
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
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
