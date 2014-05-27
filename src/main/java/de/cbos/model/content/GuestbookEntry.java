package de.cbos.model.content;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
//@Table(name="guestbookEntries")
//@PrimaryKeyJoinColumn(name="contentId")
public class GuestbookEntry extends Content {

	public GuestbookEntry() {
		setContentType("guestbookEntry");
	}

}
