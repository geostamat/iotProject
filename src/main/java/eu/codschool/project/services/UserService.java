package eu.codschool.project.services;

import java.util.List;

import eu.codschool.project.entities.User;

/**
 * Defines methods used primarily for login/register and simple
 * user access, along with the information of 
 * @author geost
 *
 */
public interface UserService {
	User findByEmail(String email);
	void save(User user);
	User findByUserID(Integer id);
	List<User> findAll();
	User getLoggedUser();
	void setLoggedUser(User loggedUser);
}
