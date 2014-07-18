package com.hashedin.devd.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.alert.AlertFilter;
import com.hashedin.devd.integration.CreateGitModelObject;
<<<<<<< HEAD

=======
import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitCommit;
>>>>>>> f12a02ca79a83436f79c067846a8bbd2f05af086
import com.hashedin.devd.model.GitModel;


@Repository("collectRepository")
@Service
public class CollectRepositoryImpl implements CollectRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private IntegrationInterface integrationInterface;
	
	@Autowired
	private GitCommitRepository gitCommitRepository;
	
	@Autowired
	private AlertFilter alertFilter;
	
	@Autowired
	private AlertRepository alertRepository;
	
<<<<<<< HEAD
	
	@Override
	public void collect() {
		
		//List<GitCommit> commits =integrationInterface.fetchData();
		//gitCommitRepository.save(commits);
		//List<Alert> alertList = alertFilter.createAlerts(commits);
		//alertRepository.save(alertList);
		CreateGitModelObject createGitModelObject = new CreateGitModelObject();
		List<GitModel> listGitModel = createGitModelObject.gitModelObject("https://api.github.com/users/tanwanirahul/events/public");
		save(listGitModel);
=======
	private CreateGitModelObject createGitModelObject;
	@Override
	public void collect() {
		
		List<GitCommit> commits =integrationInterface.fetchData();
		gitCommitRepository.save(commits);
		//List<Alert> alertList = alertFilter.createAlerts(commits);
		//alertRepository.save(alertList);
		//List<GitModel> listGitModel = createGitModelObject.gitModelObject(" https://api.github.com/users/tanwanirahul/events/public");
		//save(listGitModel);
>>>>>>> f12a02ca79a83436f79c067846a8bbd2f05af086
	}
	
	@Override
	@Transactional
	public void save(List<GitModel> gitModel) {
	
		for( GitModel gitmodel : gitModel){
			em.persist(gitmodel);
			em.flush();
		}
	}

	@Override
	public List<GitModel> find(Long userId) {
		TypedQuery<GitModel> query = em.createNamedQuery("GitModel.find",
				GitModel.class).setParameter("userId", userId);
		List<GitModel> results = query.getResultList();
		return results;
		
	}
	
}
