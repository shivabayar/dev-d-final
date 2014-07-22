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

	DisplayList displayList = new DisplayList();

	@Override
	public Map<String, Integer> collectCommitGraph() {
		return null;
	}

	@Override
	public String collectCommitGraph(String userName) {
		CreateGitModelObject createGitModelObject = new CreateGitModelObject();
		DisplayList displayCommitTrendGraph = new DisplayList();
		List<GitModel> listGitModel = createGitModelObject
				.gitModelObject(userName);
		return displayCommitTrendGraph
				.displayCommitTrendGraphFilter(listGitModel);
	}

	@Override
	public String pushCommitGraph(String userName) {
		CreateGitModelObject createGitModelObject = new CreateGitModelObject();
		DisplayList displayPullGraph = new DisplayList();
		List<GitModel> listGitModel = createGitModelObject
				.gitModelObject(userName);
		return displayPullGraph.displayPullGraphFilter(listGitModel);
	}
}
