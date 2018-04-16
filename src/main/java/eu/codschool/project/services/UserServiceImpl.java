package eu.codschool.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import eu.codschool.project.entities.User;
import eu.codschool.project.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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

}
