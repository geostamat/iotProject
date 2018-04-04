package eu.codschool.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.codschool.project.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer>{

}
