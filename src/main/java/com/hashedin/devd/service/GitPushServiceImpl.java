package com.hashedin.devd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitPush;
import com.hashedin.devd.repository.GitPushRepository;

@Repository
@Service("gitPushService")
public class GitPushServiceImpl implements GitPushService {

	@Autowired
	private GitPushRepository gitPushRepository;

	@Override
	public GitPush find(Long gitPushId) {
		// Returns the Task for given taskId.
		return gitPushRepository.find(gitPushId);
	}

	@Override
	public List<GitPush> findAll() {
		// Returns all the tasks in our system.
		return gitPushRepository.findAll();
	}

	@Override
	@Transactional
	public GitPush save(GitPush gitPush) {
		// Saves the given task object and returns the same.
		gitPushRepository.save(gitPush);
		return gitPush;
	}

	@Override
	public GitPush update(GitPush gitPull, Long gitPullId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public GitPush delete(Long gitPushId) {
		// Deletes the task with the give taskId and returns the same.
		return gitPushRepository.delete(gitPushId);
	}

	@Override
	@Transactional
	public List<GitPush> save(List<GitPush> gitPushList) {
		// saves list of gitpull objects to db
		
		for(GitPush gp : gitPushList){
			this.save(gp);
		}
		return gitPushList;
	}

}