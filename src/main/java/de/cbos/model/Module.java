package de.cbos.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;


/**JPA-Entity der DB-Tabelle "users" --> entspricht einem Eintrag**/
@Entity
@Table(name="modules")
public class Module {
	
	/** Attribute entsprechen Zeilen der Tabelle**/
	
	@Id
	 /**Spring Module Validations, nach denen User Eingaben Validiert werden**/
	@NotBlank
    @RegExp(value="^[a-zA-Z0-9][a-zA-Z0-9 ]+$")
	private String moduleName;
    
    @NotBlank
    @RegExp(value="^[a-zA-Z0-9][a-zA-Z0-9 ]+$")
	private String type;
    
	private int xKoord;
    
	private int yKoord;
    
	private int height;
    
	private int width;


    
    
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
    
    public void setXKoord(int inputXKoord) {
    	this.xKoord=inputXKoord;
    }
    
    public int getXKoord() {
    	return this.xKoord;
    }
    
    public void setYKoord(int inputYKoord) {
    	this.yKoord=inputYKoord;
    }
    
    public int getYKoord() {
    	return this.yKoord;
    }
    
    public void setHeight(int inputHeight) {
    	this.height=inputHeight;
    }
    
    public int getHeight() {
    	return this.height;
    }
    
    public void setWidth(int inputWidth) {
    	this.width=inputWidth;
    }
    
    public int getWidth() {
    	return this.width;
    }
	

}
