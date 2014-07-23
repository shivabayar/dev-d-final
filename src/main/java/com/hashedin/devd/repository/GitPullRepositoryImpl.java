package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitPull;



@Repository
public class GitPullRepositoryImpl implements GitPullRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public GitPull find(Long gitPullId) {
		return em.find(GitPull.class, gitPullId);
	}

	@Override
	public List<GitPull> findAll() {
		TypedQuery<GitPull> query = em.createNamedQuery("GitPull.findAll",
				GitPull.class);
		List<GitPull> results = query.getResultList();
		return results;
	}

	@Override
	@Transactional
	public GitPull save(GitPull gitPull) {
		em.persist(gitPull);
		em.flush();
		return gitPull;
	}

	@Override
	public GitPull update(GitPull gitPull, Long gitPullId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GitPull delete(Long gitPullId) {
		GitPull userToBeDeleted = em.find(GitPull.class, gitPullId);
		em.remove(userToBeDeleted);
		return userToBeDeleted;
	}

}
