package com.mkj.app.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDeatils implements UserDetails {
	private AppUsers user;
	
	public MyUserDeatils(AppUsers user) {
		super();
		this.user = user;
	}
	public MyUserDeatils() {	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String authority = user.getRole();
		return Arrays.asList(new SimpleGrantedAuthority(authority));
	}
	@Override
	public String getPassword() {
		String password = user.getPassword();
		return password;
	}
	@Override
	public String getUsername() {
		String username = user.getUsername();
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {		return true;	}

	@Override
	public boolean isAccountNonLocked() {	return true; }

	@Override
	public boolean isCredentialsNonExpired() {		return true;}

	@Override
	public boolean isEnabled() {	return true;	}

	
}
