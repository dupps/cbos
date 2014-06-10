package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import de.cbos.model.user.User;

@Entity
@Table(name="guestbookEntries")
@PrimaryKeyJoinColumn(name="contentId")
public class GuestbookEntry extends Content {
	
//	private User autor;
//	private Paragraph entry;
	
	public GuestbookEntry() {
		setContentType("guestbookEntry");
	}
	
	public void accept(ContentVisitor visitor) {
		visitor.visit(this);
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
