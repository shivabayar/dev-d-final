package com.hashedin.devd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hashedin.devd.model.GitUser;
import com.hashedin.devd.rest.GitUserResource;

@Service ("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private GitUserResource gitUserResource;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		final GitUser gitUser= gitUserResource.find(username);
		
		return gitUser;
	}
}
