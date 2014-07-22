package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.hashedin.devd.model.GitModel;

public class GitModelRepositoryImpl implements GitModelRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void save(List<GitModel> gitModel) {
		for (GitModel gitmodel : gitModel) {
			em.persist(gitmodel);
			em.flush();
		}
	}
}