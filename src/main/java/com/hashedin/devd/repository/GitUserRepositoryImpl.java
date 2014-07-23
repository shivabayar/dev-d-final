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

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitUser;

@Service
public class GitUserRepositoryImpl implements GitUserRepository,
		UserDetailsService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public GitUser find(Long gitUserId) {
		// Returns the Task for given taskId.
		return em.find(GitUser.class, gitUserId);
	}

	@Override
	public List<GitUser> findAll() {
		// Returns all the tasks in our system.
		TypedQuery<GitUser> query = em.createNamedQuery("GitUser.findAll",
				GitUser.class);
		List<GitUser> results = query.getResultList();
		return results;
	}

	@Override
	@Transactional
	public GitUser save(GitUser gitUser) {
		// Saves the given task object and returns the same.
		System.out.println("user jhlygelhewldj" + gitUser);
		em.persist(gitUser);
		em.flush();
		return gitUser;
	}

	@Override
	public GitUser update(GitUser gitUser, Long gitUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GitUser delete(Long gitUserId) {
		GitUser userToBeDeleted = em.find(GitUser.class, gitUserId);
		em.remove(userToBeDeleted);
		return userToBeDeleted;
	}

	@Override
	public GitUser find(String email, String password) {
		TypedQuery<GitUser> query = em
				.createNamedQuery("GitUser.find", GitUser.class)
				.setParameter("email", email)
				.setParameter("password", password);
		GitUser results = query.getSingleResult();
		return results;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		TypedQuery<GitUser> query = em.createNamedQuery("GitUser.findAll",
				GitUser.class);
		List<GitUser> results = query.getResultList();
		for (GitUser gitUser : results) {
			if (!username.equals(gitUser.getEmail())) {
				throw new UsernameNotFoundException(username + " not found");
			}
		}
		return null;
	}

	@Override
	public GitUser find(String username) {
		TypedQuery<GitUser> query = em.createNamedQuery("GitUser.findUser",
				GitUser.class).setParameter("username", username);
		GitUser results = query.getSingleResult();
		System.out.println("deddsedcdc "+results);
		return results;
	}
}
