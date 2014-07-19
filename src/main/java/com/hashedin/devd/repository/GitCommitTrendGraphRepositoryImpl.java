package com.hashedin.devd.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hashedin.devd.display.DisplayList;

@Repository
public class GitCommitTrendGraphRepositoryImpl implements GitCommitTrendGraphRepository {

	DisplayList displayList=new DisplayList();
	@Override
	public int[] collectCommitGraph() {  
		
		System.out.println("in to collectcommit graph");
		return displayList.displayList();
	
	
	}

}
