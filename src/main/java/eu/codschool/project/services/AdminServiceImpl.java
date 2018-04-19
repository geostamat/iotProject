package eu.codschool.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.codschool.project.entities.Device;
import eu.codschool.project.entities.Room;
import eu.codschool.project.repositories.DeviceRepository;
import eu.codschool.project.repositories.RoomRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	DeviceRepository deviceRepository;
	
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

}
