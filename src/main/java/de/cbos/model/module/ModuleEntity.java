package de.cbos.model.module;

public interface ModuleEntity {
	void accept(ModuleVisitor visitor);
}
