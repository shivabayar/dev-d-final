package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.Alert;

@Repository("alertRepository")
@Service
public class AlertRepositoryImpl implements AlertRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Alert find(Long userid) {
		Alert val = em.find(Alert.class, userid);
		return val;
	}

	@Override
	public List<Alert> findAll() {
		
		TypedQuery<Alert> query = em.createNamedQuery("Alert.findAll",
				Alert.class);
		List<Alert> results = query.getResultList();
		return results;
	}

	@Override
	@Transactional
	public void save(List<Alert> alertList) {
		for (Alert alert : alertList) {
			em.persist(alert);
			em.flush();
		}
	}

	@Override
	@Transactional
	public void save(Alert alert) {
		em.persist(alert);
		em.flush();

	}

	@Override
	public Alert update(Alert alert, Long alertId) {
		return null;
	}

	@Override
	public Alert delete(Long alertId) {
		Alert taskToBeDeleted = em.find(Alert.class, alertId);
		em.remove(taskToBeDeleted);
		return taskToBeDeleted;
	}
}
