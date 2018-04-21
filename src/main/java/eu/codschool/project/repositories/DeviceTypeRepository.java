package eu.codschool.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.codschool.project.entities.DeviceType;

/**
 * Provides the default JpaRepository methods for the DeviceType entity
 * @author geost
 *
 */

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer>{
	
}
