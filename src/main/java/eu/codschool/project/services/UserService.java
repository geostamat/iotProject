package eu.codschool.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import eu.codschool.project.entities.User;

public interface UserService {
	User findByEmail(String email);
	void save(User user);
	User findByUserID(Integer id);
	List<User> findAll();
}
