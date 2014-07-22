package com.hashedin.devd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitPull;
import com.hashedin.devd.repository.GitPullRepository;

@Repository
@Service("gitPullService")
public class GitPullServiceImpl implements GitPullService {

	@Autowired
	private GitPullRepository gitPullRepository;

	@Override
	public GitPull find(Long gitPullRequestId) {
		// Returns the Task for given taskId.
		return gitPullRepository.find(gitPullRequestId);
	}

	@Override
	public List<GitPull> findAll() {
		// Returns all the tasks in our system.
		return gitPullRepository.findAll();
	}
	
	@Override
	@Transactional
	public GitPull save(GitPull gitPull) {
		// Saves the given task object and returns the same.
		gitPullRepository.save(gitPull);
		return gitPull;
	}

	@Override
	public GitPull update(GitPull gitPull,
			Long gitPullId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public GitPull delete(Long gitPullId) {
		// Deletes the task with the give taskId and returns the same.
		return gitPullRepository.delete(gitPullId);
	}

	@Override
	@Transactional
	public List<GitPull> save(List<GitPull> gitPullList) {
		// saves list of gitpull objects to db
		
		for(GitPull gp : gitPullList){
			this.save(gp);
		}
		return gitPullList;
	}

}
