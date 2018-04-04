package eu.codschool.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeid", nullable = false)
    private DeviceType deviceType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomid", nullable = false)
    private Room room;
    
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

	public Device() {}

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
	
	
}

