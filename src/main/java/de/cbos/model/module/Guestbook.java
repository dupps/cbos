package de.cbos.model.module;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import de.cbos.model.content.GuestbookEntry;

@Entity
@Table(name = "guestbooks")
@PrimaryKeyJoinColumn(name = "moduleId")
public class Guestbook extends Module {
	
	public Guestbook() {
		setType("guestbook");
	}
	
//	@OneToMany
//	private GuestbookEntry guestbookEntry;

//	public GuestbookEntry getGuestbookEntry() {
//		return guestbookEntry;
//	}
//
//	public void setGuestbookEntry(GuestbookEntry guestbookEntry) {
//		this.guestbookEntry = guestbookEntry;
//	}
	
}
