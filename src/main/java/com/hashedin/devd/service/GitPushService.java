package com.hashedin.devd.service;

import java.util.List;

import com.hashedin.devd.model.GitPush;

public interface GitPushService {
	GitPush find(Long gitPullRequestId);

	List<GitPush> findAll();

	GitPush save(GitPush gitPush);

	GitPush update(GitPush gitPush, Long gitPushId);

	GitPush delete(Long gitPushId);
	
	List<GitPush> save(List<GitPush> gitPushList);
}
