package com.hashedin.devd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitUser;
import com.hashedin.devd.repository.GitUserRepository;

@Repository
@Service("gitUserService")
public class GitUserServiceImpl implements GitUserService {
	@Autowired
	private GitUserRepository gitUserRepository;

	@Override
	public List<GitUser> findAll() {
		// Returns all the tasks in our system.
		return gitUserRepository.findAll();
	}

	@Override
	@Transactional
	public GitUser save(GitUser gitUser) {
		// Saves the given task object and returns the same.
		gitUserRepository.save(gitUser);
		return gitUser;
	}

	@Override
	public GitUser update(GitUser gitUser, Long gitUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public GitUser delete(Long gitUserId) {
		// Deletes the task with the give taskId and returns the same.
		return gitUserRepository.delete(gitUserId);
	}

	@Override
	public GitUser find(String email, String password) {
		// TODO Auto-generated method stub
		return gitUserRepository.find(email, password);
	}

	@Override
	public GitUser find(String username) {
		return gitUserRepository.find(username);
	}

}
