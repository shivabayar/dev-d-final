package com.hashedin.devd.repository;

import java.util.List;

import org.jvnet.hk2.annotations.Service;

import com.hashedin.devd.model.GitCommit;

public interface GitCommitRepository {
	GitCommit find(Long commitId);

	List<GitCommit> findAll();

	void save(List<GitCommit> gitCommit);

	GitCommit update(GitCommit gitCommit, Long commitId);

	GitCommit delete(Long commitId);
	
	GitCommit save(GitCommit gitCommit);

}
