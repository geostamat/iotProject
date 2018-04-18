package eu.codschool.project.services;

import java.util.List;

import eu.codschool.project.entities.Device;
import eu.codschool.project.entities.Room;

public interface AdminService {
	
	List<Room> getAllRooms();
	void addRoom(Room room);
	List<Device> getAllDevices();
	void addDevice(Device device);

}
