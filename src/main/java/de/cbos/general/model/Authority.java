package de.cbos.general.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**JPA-Entity der DB-Tabelle "authorities"ß**/
@Entity
@Table(name="authorities")
public class Authority {
	
    @Id
	private String UserName;
    
    private String Authority;
    
    public void setUserName(String userName) {
    	this.UserName=userName;
    }
    
    public String getUserName() {
    	return this.UserName;
    }
    
    public void setAuthority(String authority) {
    	this.Authority=authority;
    }
    
    public String getAuthority() {
    	return this.Authority;
    }
    

}
