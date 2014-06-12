package de.cbos.model.module;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

import de.cbos.model.content.Content;
import de.cbos.model.page.Page;


/**JPA-Entity der DB-Tabelle "users" --> entspricht einem Eintrag**/
@Entity
@Table(name="modules")
@Inheritance(strategy=InheritanceType.JOINED)
public class Module implements ModuleEntity {
	
	/** Attribute entsprechen Zeilen der Tabelle**/
	
	@Id
	@GeneratedValue
	private int moduleId;
	
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@RegExp(value="^[a-zA-Z0-9][a-zA-Z0-9 ]+$")
	private String moduleName;
    
	private String type;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="pageName")
	private Page page;
	
	public void accept(ModuleVisitor visitor) {
		
	}
	
    public void setModuleName(String inputName) {
    	this.moduleName=inputName;
    }
    
    public String getModuleName() {
    	return this.moduleName;
    }
    
    public void setType(String inputType) {
    	this.type=inputType;
    }
    
    public String getType() {
    	return this.type;
    }

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
    

}
