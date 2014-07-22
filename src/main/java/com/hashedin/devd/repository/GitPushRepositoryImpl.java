package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitPush;

@Repository
public class GitPushRepositoryImpl implements GitPushRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<GitPush> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<GitPush> query = em.createNamedQuery("GitPush.findAll",
				GitPush.class);
		List<GitPush> results = query.getResultList();
		return results;
	}

	@Override
	@Transactional
	public void save(GitPush gitPush) {

		em.persist(gitPush);
		em.flush();

	}

	@Override
	public GitPush update(GitPush gitPush, Long gitPushId) {

		return null;
	}

	@Override
	public GitPush delete(Long gitPushId) {
		GitPush userToBeDeleted = em.find(GitPush.class, gitPushId);
		em.remove(userToBeDeleted);
		return userToBeDeleted;
	}

	@Override
	public GitPush find(Long gitPushId) {
		return em.find(GitPush.class, gitPushId);
	}

}
