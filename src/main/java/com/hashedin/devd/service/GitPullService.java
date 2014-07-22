package com.hashedin.devd.service;

import java.util.List;

import com.hashedin.devd.model.GitPull;

public interface GitPullService {
	GitPull find(Long gitPullRequestId);

	List<GitPull> findAll();

	GitPull save(GitPull gitPull);

	List<GitPull> save(List<GitPull> gitPull);
	
	GitPull update(GitPull gitPull, Long gitPullId);

	GitPull delete(Long gitPullId);
}
