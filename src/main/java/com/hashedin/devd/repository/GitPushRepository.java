package com.hashedin.devd.repository;

import java.util.List;

import com.hashedin.devd.model.GitPush;

public interface GitPushRepository {

	List<GitPush> findAll();

	void save(GitPush gitPushList);

	GitPush update(GitPush gitPush, Long gitPushId);

	GitPush delete(Long gitPushId);

	GitPush find(Long gitPushId);

}
