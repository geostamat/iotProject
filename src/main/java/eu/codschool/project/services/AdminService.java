package eu.codschool.project.services;

import java.util.List;

import eu.codschool.project.entities.Device;
import eu.codschool.project.entities.DeviceType;
import eu.codschool.project.entities.Room;
import eu.codschool.project.entities.User;

/**
 * Defines methods used primarily by the users with administrator access.
 * @author geost
 *
 */

public interface AdminService {
	
	List<Room> getAllRooms();
	void addRoom(Room room);
	List<Device> getAllDevices();
	void addDevice(Device device);
	List<DeviceType> getAllDeviceTypes();
	void deleteRoom(Room room);
	Room getRoomById(Integer id);
	List<User> getAllUsers();
	void deleteDevice(Device device);
	Device getDeviceById(Integer deviceId);

}
