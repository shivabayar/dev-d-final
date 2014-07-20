package com.hashedin.devd.repository;

import com.hashedin.devd.display.DisplayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.alert.AlertFilter;
import com.hashedin.devd.integration.CreateGitModelObject;
import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;

@Repository("collectRepository")
@Service
public class CollectRepositoryImpl implements CollectRepository {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AlertFilter alertFilter;

	/*
	 * @Autowired public DisplayList displayList;
	 */

	@Autowired
	private AlertRepository alertRepository;

	private CreateGitModelObject createGitModelObject = new CreateGitModelObject();

	@Override
	@Transactional
	public void collect(String userName) {
		//function call to get username tanwanirahul

		List<GitModel> listGitModel = createGitModelObject
				.gitModelObject(userName);
		Alert alertList = alertFilter.createFilter(listGitModel);

		DisplayList displayList = new DisplayList();
		displayList.displayFilter(listGitModel);
		save(listGitModel,userName);
		alertRepository.save(alertList,userName);
	}

	@Override
	@Transactional
	public void save(List<GitModel> gitModel, String userName) {
		List<GitModel> results = find(userName);
		if(results==null){
			for (GitModel gitmodel : gitModel) {
				em.persist(gitmodel);
				em.flush();
			}
		}
		else{
			delete(userName);
			for (GitModel gitmodel : gitModel) {
				em.persist(gitmodel);
				em.flush();
			}
		}
	}

	@Override
	public List<GitModel> find(String username) {
		TypedQuery<GitModel> query = em.createNamedQuery("GitModel.find",
				GitModel.class).setParameter("username", username);
		List<GitModel> results = query.getResultList();
		return results;

	}

	@Override
	@Transactional
	public void delete(String username) {
		Query q = em.createQuery ("DELETE FROM GitModel s WHERE s.userName= :userName");
		q.setParameter ("userName", username);
		int deleted = q.executeUpdate ();

	}
	@Override
	public Alert save(Alert alert) {
		// TODO Auto-generated method stub
		return null;
	}
}
