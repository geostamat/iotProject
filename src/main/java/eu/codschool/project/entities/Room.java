package eu.codschool.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "room")
public class Room {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "roomid")
	private Integer roomId;
    @Column(name = "roomname")
	private String roomName;
    	
	public Room() {}
	
	public Room(String name) {
		this.roomName = name;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomid) {
		this.roomId = roomid;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return roomName;
	}
	
	
}