package de.cbos.model.module;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;


/**JPA-Entity der DB-Tabelle "users" --> entspricht einem Eintrag**/
@Entity
@Table(name="modules")
@Inheritance(strategy=InheritanceType.JOINED)
public class Module {
	
	/** Attribute entsprechen Zeilen der Tabelle**/
	
	@Id
	@GeneratedValue
	private int moduleId;
	
	@NotBlank
    @RegExp(value="^[a-zA-Z0-9][a-zA-Z0-9 ]+$")
	private String moduleName;
    
	private String type;
    
    /**
     * Getter and Setter-Methoden
     */
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
    
    public int getId() {
    	return this.moduleId;
    }
}
