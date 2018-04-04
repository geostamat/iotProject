package eu.codschool.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.codschool.project.entities.DeviceType;

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer>{
	
}
