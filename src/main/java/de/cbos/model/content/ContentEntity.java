package de.cbos.model.content;

public interface ContentEntity {
	void accept(ContentVisitor visitor);
}
