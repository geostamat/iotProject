package eu.codschool.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import eu.codschool.project.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
