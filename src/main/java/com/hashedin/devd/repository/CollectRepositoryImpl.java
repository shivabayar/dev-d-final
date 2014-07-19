package com.hashedin.devd.repository;

import com.hashedin.devd.display.DisplayList;
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
	public void collect() {

		List<GitModel> listGitModel = createGitModelObject
				.gitModelObject("tanwanirahul");
		Alert alertList = alertFilter.createFilter(listGitModel);

		DisplayList displayList = new DisplayList();
		displayList.displayFilter(listGitModel);
		save(listGitModel);
		alertRepository.save(alertList);
	}

	@Override
	@Transactional
	public void save(List<GitModel> gitModel) {

		for (GitModel gitmodel : gitModel) {
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

	@Override
	public Alert save(Alert alert) {
		// TODO Auto-generated method stub
		return null;
	}
}
