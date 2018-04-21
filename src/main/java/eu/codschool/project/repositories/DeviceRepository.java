package eu.codschool.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.codschool.project.entities.Device;

/**
 * Provides the default JpaRepository methods for the Device entity
 * @author geost
 *
 */

public interface DeviceRepository extends JpaRepository<Device, Integer>{

}
