package eu.codschool.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.codschool.project.entities.Room;

/**
 * Provides Room specific repository methods.
 * @author geost
 *
 */

public interface RoomRepository extends JpaRepository<Room, Integer> {
	Room findByRoomId(Integer roomId);
}
