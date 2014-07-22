 package com.hashedin.devd.repository;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.hashedin.devd.display.DisplayList;
import com.hashedin.devd.integration.CreateGitModelObject;
import com.hashedin.devd.model.GitModel;

@Repository
public class GitCommitTrendGraphRepositoryImpl implements
		GitCommitTrendGraphRepository {

	DisplayList displayTrendGraph = new DisplayList();

	@Override
	public Map<String, Integer> collectCommitGraph() {
		return null;
	}

	@Override
	public String collectCommitGraph(String userName) {
		return displayTrendGraph
				.displayCommitTrendGraphFilter(listGitModel(userName));
	}

	@Override
	public String pushCommitGraph(String userName) {
		return displayTrendGraph.displayPullGraphFilter(listGitModel(userName));
	}

	public List<GitModel> listGitModel(String userName) {
		CreateGitModelObject createGitModelObject = new CreateGitModelObject();
		List<GitModel> listGitModel = createGitModelObject
				.gitModelObject(userName);
		return listGitModel;

	}

}