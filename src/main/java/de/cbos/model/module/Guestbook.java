package de.cbos.model.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import de.cbos.model.content.GuestbookEntry;

@Entity
@Table(name = "guestbooks")
@PrimaryKeyJoinColumn(name = "moduleId")
public class Guestbook extends Module {
	
	@OneToMany (mappedBy="guestbook", fetch=FetchType.EAGER)
	private List<GuestbookEntry> guestbookEntries = new ArrayList<GuestbookEntry>();
	
	public Guestbook() {
		setType("guestbook");
		List<GuestbookEntry> guestbookEntries = new ArrayList<GuestbookEntry>();
		setGuestbookEntries(guestbookEntries); 
	}

	public void accept(ModuleVisitor visitor) {
		visitor.visit(this);
	}

	public List<GuestbookEntry> getGuestbookEntries() {
		return this.guestbookEntries;
	}

	public void setGuestbookEntries(List<GuestbookEntry> guestbookEntries) {
		this.guestbookEntries = guestbookEntries;
	}
}
