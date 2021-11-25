package com.mkj.app.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mkj.app.entity.AppUsers;
import com.mkj.app.entity.MyUserDeatils;
import com.mkj.app.repo.AppUserRepository;

@Service
public class AppUserServiceImpl implements UserDetailsService{

	@Autowired
	private AppUserRepository userRepo;

	@Override  // from UserDetailsService
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("-------->> inside AppUserServiceImpl load users "+username);
		//AppUsers user =  userRepo.getUsersByUsername(username);
		
		User user1 = new User("raja","abc",Arrays.asList(new SimpleGrantedAuthority("admin")));
		
		//return new MyUserDeatils(user);
		return user1;
	}
}


