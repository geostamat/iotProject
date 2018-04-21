package eu.codschool.project.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entity that describes the user. Information includes name and last name,
 * unique email, encrypted password, role (0 for administrator and 1 for
 * simple user) and a list of the devices they can access (for simple users).  
 * @author geost
 *
 */
@Entity
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userID;
    @Column(name = "name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="email")
    private String email;
    @Column(columnDefinition = "char")
    private String password;
    @Column(name="role")
    private Integer role;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_devices", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userid"), inverseJoinColumns = @JoinColumn(name = "device_id", referencedColumnName = "deviceid"))
    private Set<Device> devices;
    
    public User() {}
    
    public User(String name, String surname, String email, String password) {
    	this.name = name;
    	this.surname = surname;
    	this.email = email;
    	this.password = password;
    	this.role = 0;
    }

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Set<Device> getDevices() {
		return devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}
    
}
