package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitUser;

/**
 * The Class GitUserRepositoryImpl.
 */
@Service
public class GitUserRepositoryImpl implements GitUserRepository,
UserDetailsService {

	/** The em. */
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see com.hashedin.devd
	 * .repository.GitUserRepository#find(java.lang.Long)
	 */
	@Override
	public final GitUser find(final Long gitUserId) {
		// Returns the Task for given taskId.
		return em.find(GitUser.class, gitUserId);
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository.GitUserRepository#findAll()
	 */
	@Override
	public final List<GitUser> findAll() {
		// Returns all the tasks in our system.
		TypedQuery<GitUser> query = em
				.createNamedQuery("GitUser.findAll",
				GitUser.class);
		List<GitUser> results = query.getResultList();
		return results;
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .GitUserRepository#save(com.hashedin.devd.model.GitUser)
	 */
	@Override
	@Transactional
	public final GitUser save(final GitUser gitUser) {
		// Saves the given task object and returns the same.
		System.out.println("user jhlygelhewldj" + gitUser);
		em.persist(gitUser);
		em.flush();
		return gitUser;
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .GitUserRepository#delete(java.lang.Long)
	 */
	@Override
	public final GitUser delete(final Long gitUserId) {
		GitUser userToBeDeleted = em.find(GitUser.class, gitUserId);
		em.remove(userToBeDeleted);
		return userToBeDeleted;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails
	 * .UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public final UserDetails loadUserByUsername(final String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository.
	 * GitUserRepository#find(java.lang.String, java.lang.String)
	 */
	@Override
	public final GitUser find(final String email, final String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .GitUserRepository#find(java.lang.String)
	 */
	@Override
	public final GitUser find(final String username) {
		// TODO Auto-generated method stub
		TypedQuery<GitUser> query = em
				.createNamedQuery("GitUser.findUser",
				GitUser.class)
				.setParameter("username", username);
		GitUser results = query.getSingleResult();
		return results;
	}
}

