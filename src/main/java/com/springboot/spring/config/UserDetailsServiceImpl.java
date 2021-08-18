package com.springboot.spring.config;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.spring.Model.User;
import com.springboot.spring.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	

	@Override
//	@Transactional(readOnly= true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);
		
		
		Set< GrantedAuthority > grantedAuthorities = new HashSet < > ();
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
		
	}
	
	

}
