package com.hashedin.devd.service;

import java.util.List;

import com.hashedin.devd.model.GitUser;;

public interface GitUserService {
	GitUser find(Long gitUserId);

	List<GitUser> findAll();

	GitUser save(GitUser gitUser);

	GitUser delete(Long gitUserId);
	
	GitUser find (String email, String password);
	GitUser find (String username);
}
