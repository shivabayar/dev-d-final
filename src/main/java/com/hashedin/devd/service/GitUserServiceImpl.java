package com.hashedin.devd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitUser;
import com.hashedin.devd.repository.GitUserRepository;

/**
 * The Class GitUserServiceImpl.
 */
@Repository
@Service("gitUserService")
public class GitUserServiceImpl implements GitUserService {

	/** The git user repository. */
	@Autowired
	private GitUserRepository gitUserRepository;

	/* (non-Javadoc)
	 * @see com.hashedin.devd.service.GitUserService#find(java.lang.Long)
	 */
	@Override
	public final GitUser find(final Long gitUserId) {
		// Returns the Task for given taskId.
		return gitUserRepository.find(gitUserId);
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.service.GitUserService#findAll()
	 */
	@Override
	public final List<GitUser> findAll() {
		// Returns all the tasks in our system.
		return gitUserRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.service
	 * .GitUserService#save(com.hashedin.devd.model.GitUser)
	 */
	@Override
	@Transactional
	public final GitUser save(final GitUser gitUser) {
		// Saves the given task object and returns the same.
		gitUserRepository.save(gitUser);
		return gitUser;
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.service.GitUserService#delete(java.lang.Long)
	 */
	@Transactional
	public GitUser delete(final Long gitUserId) {
		// Deletes the task with the give taskId and returns the same.
		return gitUserRepository.delete(gitUserId);
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.service
	 * .GitUserService#find(java.lang.String, java.lang.String)
	 */
	@Override
	public final GitUser find(final String email, final String password) {
		// TODO Auto-generated method stub
		return gitUserRepository.find(email, password);
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.service.GitUserService#find(java.lang.String)
	 */
	@Override
	public final GitUser find(final String username) {
		return gitUserRepository.find(username);
	}

}
