package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;

@Repository("alertRepository")
@Service
public class AlertRepositoryImpl implements AlertRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Alert find(String username) {
		TypedQuery<Alert> query = em.createNamedQuery("Alert.find",
				Alert.class).setParameter("username", username);
		Alert results = query.getSingleResult();
		return results;
		
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
	public void save(Alert alert, String userName) {
		List<Alert> results = findAll();
		boolean IsPresent=false;
		for(Alert alrt:results){
			if(alrt.getUserName() == userName && !IsPresent){
				IsPresent=true;
			}
		}
		if(!IsPresent){
			em.persist(alert);
			em.flush();
		}
		else {
			delete(userName);
			em.persist(alert);
			em.flush();
		}
	}

	@Override
	public Alert update(Alert alert, Long alertId) {
		return null;
	}

	@Override
	public void delete(String userName) {
		Query q = em.createQuery ("DELETE FROM Alert a WHERE a.userName= :userName");
		q.setParameter ("userName", userName);
		int deleted = q.executeUpdate ();
	}
}
