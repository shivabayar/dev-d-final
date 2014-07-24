package com.hashedin.devd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hashedin.devd.model.GitUser;
import com.hashedin.devd.rest.GitUserResource;

/**
 * The Class UserDetailServiceImpl.
 */
@Service ("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

	/** The git user resource. */
	@Autowired
	private GitUserResource gitUserResource;

	/* (non-Javadoc)
	 * @see org.springframework.security
	 * .core.userdetails.UserDetailsService
	 * #loadUserByUsername(java.lang.String)
	 */
	@Override
	public final UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		final GitUser gitUser = gitUserResource.find(username);
		return gitUser;
	}
}
