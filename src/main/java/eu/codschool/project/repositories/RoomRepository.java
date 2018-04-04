package eu.codschool.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.codschool.project.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {


}
