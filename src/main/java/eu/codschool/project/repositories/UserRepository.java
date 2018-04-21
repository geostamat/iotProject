package eu.codschool.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.codschool.project.entities.User;

/**
 * Provides user specific methods for the user entity.
 * @author geost
 *
 */

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
	User findByUserID(Integer userID);
}
