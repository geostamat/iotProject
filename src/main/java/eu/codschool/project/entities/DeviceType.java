package eu.codschool.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity that describes the type of the device.
 * @author geost
 *
 */

@Entity(name = "device_type")
public class DeviceType {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "typeid")
	private Integer id;
    @Column(name = "name")
    private String type;
    
    public DeviceType() {}
    
    public DeviceType(String deviceType) {
    	this.type = deviceType;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
	@Override
	public String toString() {
		return this.type;
	}
}
