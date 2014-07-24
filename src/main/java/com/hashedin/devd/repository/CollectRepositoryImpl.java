package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.alert.AlertFilter;
import com.hashedin.devd.integration.CreateGitModelObject;
import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;

/**
 * The Class CollectRepositoryImpl.
 */
@Repository("collectRepository")
@Service
public class CollectRepositoryImpl implements CollectRepository {

	/** The Constant s_log. */
	private static final Logger s_log = Logger
			.getLogger(CollectRepository.class);

	/** The em. */
	@PersistenceContext
	private EntityManager em;

	/** The alert filter. */
	@Autowired
	private AlertFilter alertFilter;

	/** The alert repository. */
	@Autowired
	private AlertRepository alertRepository;

	/** The create git model object. */
	private CreateGitModelObject
	createGitModelObject = new CreateGitModelObject();

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .CollectRepository#collect(java.lang.String)
	 */
	@Override
	@Transactional
	public final void collect(final String userName) {
		// function call to get username tanwanirahul
		try {
			List<GitModel> listGitModel = createGitModelObject
					.gitModelObject(userName);
			//System.out.println("listModel "+listGitModel);
			save(listGitModel, userName);
			Alert alertList = alertFilter
					.createFilter(listGitModel);
			//System.out.println("alertList "+alertList);
			alertRepository.save(alertList, userName);
		} catch (Exception ex) {
			s_log.error(ex);
		}
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .CollectRepository#save(java.util.List, java.lang.String)
	 */
	@Override
	@Transactional
	public final void save(final List<GitModel> gitModel
			, final String userName) {
		List<GitModel> results = find(userName);
		if (results == null) {

			for (GitModel gitmodel : gitModel) {
				em.persist(gitmodel);
				em.flush();
			}
			delete();
		} else {

			delete(userName);
			for (GitModel gitmodel : gitModel) {
				em.persist(gitmodel);
				em.flush();
			}
			delete();
		}
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .CollectRepository#find(java.lang.String)
	 */
	@Override
	public final List<GitModel> find(final String username) {
		TypedQuery<GitModel> query = em
				.createNamedQuery("GitModel.find",
				GitModel.class)
				.setParameter("username", username);
		List<GitModel> results = query.getResultList();
		System.out.println("dededd +results");
		return results;

	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .CollectRepository#delete(java.lang.String)
	 */
	@SuppressWarnings("unused")
	@Override
	@Transactional
	public final void delete(final String username) {
		Query q = em
				.createQuery("DELETE FROM GitModel s "
					+ "WHERE s.userName= :userName");
		q.setParameter("userName", username);
		int deleted = q.executeUpdate();

	}

 /* (non-Javadoc)
	 * @see com.hashedin.devd.repository.CollectRepository#delete()
	 */
	@SuppressWarnings("unused")
	@Override
	@Transactional
	public final void delete() {
		Query q = em
				.createQuery("DELETE FROM GitModel"
						+ " s WHERE s.gitUserId= 0");
		int deleted = q.executeUpdate();

	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository.CollectRepository#listAll()
	 */
	@Override
	public final List<GitModel> listAll() {
		TypedQuery<GitModel> query = em
				.createNamedQuery("GitModel.findAll",
				GitModel.class);
		List<GitModel> results = query.getResultList();
		return results;
	}
}
