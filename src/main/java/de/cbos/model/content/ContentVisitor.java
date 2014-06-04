package de.cbos.model.content;

public interface ContentVisitor {
	void visit(Paragraph paragraph);
	void visit(GuestbookEntry guestbookEntry);
}
