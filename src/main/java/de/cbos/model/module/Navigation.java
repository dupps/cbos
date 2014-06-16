package de.cbos.model.module;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "navigations")
@PrimaryKeyJoinColumn(name = "moduleId")
public class Navigation extends Module  {

	public Navigation() {
		setType("navigation");
	}

	public void accept(ModuleVisitor visitor) {
		visitor.visit(this);
	}
}
