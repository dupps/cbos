package de.cbos.model.user;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;


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
