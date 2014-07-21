package com.hashedin.devd.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hashedin.devd.display.DisplayList;
import com.hashedin.devd.integration.CreateGitModelObject;
import com.hashedin.devd.model.GitModel;

@Repository
public class GitCommitTrendGraphRepositoryImpl implements GitCommitTrendGraphRepository {

	DisplayList displayList=new DisplayList();
	@Override
	public Map<String, Integer> collectCommitGraph() {  
		
		System.out.println("in to collectcommit graph");
		//return displayList.displayList();
	//	return displayList.getDisplayList();
		return null;
	
	}

	//DisplayList displayList=new DisplayList();
	@Override
	public String collectCommitGraph(String userName) {  
		CreateGitModelObject createGitModelObject =new CreateGitModelObject();
		DisplayList displayList = new DisplayList();
		//System.out.println("in to collectcommit graph"+ displayList.displayList());
		List<GitModel> listGitModel = createGitModelObject.gitModelObject(userName);
		displayList.displayFilter(listGitModel);
		return displayList.displayFilter(listGitModel);
	}
}
