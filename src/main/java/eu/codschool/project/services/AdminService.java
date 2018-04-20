package eu.codschool.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import eu.codschool.project.entities.Device;
import eu.codschool.project.entities.DeviceType;
import eu.codschool.project.entities.Room;
import eu.codschool.project.entities.User;

public interface AdminService {
	
	List<Room> getAllRooms();
	void addRoom(Room room);
	List<Device> getAllDevices();
	void addDevice(Device device);
	List<DeviceType> getAllDeviceTypes();
	void deleteRoom(Room room);
	Room getRoomById(Integer id);
	List<User> getAllUsers();

}
