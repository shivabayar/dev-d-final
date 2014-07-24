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
/**
 * The Class AlertRepositoryImpl.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
@Repository("alertRepository")
@Service
public class AlertRepositoryImpl implements AlertRepository {

/** The em. */
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .AlertRepository#find(java.lang.String)
	 */
	@Override
	public final List<Alert> find(final String username) {
		TypedQuery<Alert> query = em
				.createNamedQuery("Alert.find", Alert.class)
				.setParameter("username", username);
		List<Alert> results = query.getResultList();
		return results;
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .AlertRepository#save(com.hashedin.devd
	 * .model.Alert, java.lang.String)
	 */
	@Override
	@Transactional
	public final void save(final Alert alert, final String userName) {
		List<Alert> results = find(userName);
		if (results == null) {
			em.persist(alert);
			em.flush();
		} else {
			delete(userName);
			em.persist(alert);
			em.flush();
		}
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .AlertRepository#delete(java.lang.String)
	 */
	@SuppressWarnings("unused")
	@Override
	public final void delete(final String userName) {
		Query q = em
				.createQuery("DELETE FROM Alert a "
					+ "WHERE a.userName= :userName");
		q.setParameter("userName", userName);
		int deleted = q.executeUpdate();
	}
}
