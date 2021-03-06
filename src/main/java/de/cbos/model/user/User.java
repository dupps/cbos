package de.cbos.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.engine.spi.CascadeStyle;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

import de.cbos.model.content.GuestbookEntry;


/**JPA-Entity der DB-Tabelle "users" --> entspricht einem Eintrag**/
@Entity
@Table(name="users")
public class User {
	
	/** Attribute entsprechen Zeilen der Tabelle**/
	
	@Id
	 /**Spring Module Validations, nach denen User Eingaben Validiert werden**/
	@NotBlank
    @RegExp(value="^[a-zA-Z0-9][a-zA-Z0-9 ]+$")
	private String userName;
    
    @NotBlank
    @Email
	private String email;
    
    @NotBlank
	private String city;
    
    @NotBlank
	private String birthday;

    private String password;
    
    private boolean enabled;
    
    @GeneratedValue
    @NotNull
    private int userId;
    
    @OneToMany (cascade=CascadeType.REMOVE, orphanRemoval=true, mappedBy="author", fetch=FetchType.EAGER)
    @Fetch (value=FetchMode.SUBSELECT)
    private List<GuestbookEntry> guestbookEntries = new ArrayList<GuestbookEntry>();
    
    public List<GuestbookEntry> getGuestbookEntries() {
		return guestbookEntries;
	}
	public void setGuestbookEntries(List<GuestbookEntry> guestbookEntries) {
		this.guestbookEntries = guestbookEntries;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
     * Getter and Setter-Methoden
     */
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birth) {
		this.birthday = birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

}
