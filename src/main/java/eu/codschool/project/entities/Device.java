package eu.codschool.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity that contains the information for a device. That includes
 * a name by which is know to the users, its IP Address where it will be
 * accessed through a web service, and the API Key required to access that
 * service.
 * Administrator can access all devices, whereas simple users can access
 * only the devices the administrator has granted them privileges for.
 * @author geost
 *
 */

@Entity
public class Device {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "deviceid")
	private Integer deviceID;
    @Column(name = "name")
    private String deviceName;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "api_key")
    private String apiKey;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeid", nullable = false)
    private DeviceType deviceType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomid", nullable = false)
    private Room room;
    
	public Device() {}
	
    public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deveviceType) {
		this.deviceType = deveviceType;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(Integer deviceID) {
		this.deviceID = deviceID;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
    public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}	
	
}

