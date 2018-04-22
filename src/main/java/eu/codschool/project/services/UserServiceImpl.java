package eu.codschool.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import eu.codschool.project.entities.User;
import eu.codschool.project.repositories.UserRepository;
/**
 * Implements the methods needed for user authentication and holds,
 * the logged user.
 * @author geost
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private User loggedUser = null;
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);	
	}
	
	

	@Override
	public User findByUserID(Integer id) {
		return userRepository.findByUserID(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getLoggedUser() {
		return this.loggedUser;
	}

	@Override
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
		
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

}
