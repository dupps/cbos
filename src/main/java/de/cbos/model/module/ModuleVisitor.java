package de.cbos.model.module;

public interface ModuleVisitor {
	void visit(Textcontainer textcontainer);
	void visit(Guestbook guestbook);
	void visit(Navigation navigation);
}
