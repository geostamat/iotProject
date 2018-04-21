package eu.codschool.project.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eu.codschool.project.entities.User;

/**
 * Service used by Spring Security
 * @author geost
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findByEmail(email);
		userService.setLoggedUser(user);
		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
		grantedAuthority.add(new SimpleGrantedAuthority(user.getRole() + ""));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthority);
	}
	
	public Set<GrantedAuthority> getGrantedAuthorities(User user){
		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
		grantedAuthority.add(new SimpleGrantedAuthority(user.getRole() + ""));	
		return grantedAuthority;
	}
	
	
}
