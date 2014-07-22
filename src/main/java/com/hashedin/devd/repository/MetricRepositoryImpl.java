package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitMetric;

@Repository("metricRepository")
public class MetricRepositoryImpl implements MetricRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<GitMetric> findAll() {
		// Returns all the metrics in our system.
		TypedQuery<GitMetric> query = em.createNamedQuery("GitMetric.findAll",
				GitMetric.class);
		List<GitMetric> results = query.getResultList();
		return results;
	}

	@Override
	@Transactional
	public GitMetric save(GitMetric metric) {
		// Saves the given metric object and returns the same.
		em.persist(metric);
		em.flush();
		return metric;
	}

}
