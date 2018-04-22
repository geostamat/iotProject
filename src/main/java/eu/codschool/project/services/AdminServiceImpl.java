package eu.codschool.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.codschool.project.entities.Device;
import eu.codschool.project.entities.DeviceType;
import eu.codschool.project.entities.Room;
import eu.codschool.project.entities.User;
import eu.codschool.project.repositories.DeviceRepository;
import eu.codschool.project.repositories.DeviceTypeRepository;
import eu.codschool.project.repositories.RoomRepository;
import eu.codschool.project.repositories.UserRepository;

/**
 * Implements the methods used primarily by administrators. 
 * @author geost
 *
 */

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	DeviceRepository deviceRepository;
	
	@Autowired
	DeviceTypeRepository deviceTypeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public void addRoom(Room room) {
		roomRepository.save(room);
		
	}

	@Override
	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	@Override
	public void addDevice(Device device) {
		deviceRepository.save(device);
	}

	@Override
	public List<DeviceType> getAllDeviceTypes() {
		return deviceTypeRepository.findAll();
	}

	@Override
	public void deleteRoom(Room room) {
		roomRepository.delete(room);
		
	}

	@Override
	public Room getRoomById(Integer id) {
		return roomRepository.findByRoomId(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteDevice(Device device) {
		deviceRepository.delete(device);		
	}

	@Override
	public Device getDeviceById(Integer deviceId) {
		return deviceRepository.findByDeviceID(deviceId);
	}

}
