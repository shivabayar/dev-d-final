package com.hashedin.devd.repository;

import java.util.List;

import com.hashedin.devd.model.GitUser;

public interface GitUserRepository {
	GitUser find(Long gitUserId);

	List<GitUser> findAll();

	GitUser save(GitUser gitUser);

	GitUser update(GitUser gitUser, Long gitUserId);

	GitUser delete(Long gitUserId);
	
	GitUser find(String email, String password);
	GitUser find(String username);
}
