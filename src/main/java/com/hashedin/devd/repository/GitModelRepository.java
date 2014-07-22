package com.hashedin.devd.repository;

import java.util.List;

import com.hashedin.devd.model.GitModel;

public interface GitModelRepository {
	void save(List<GitModel> gitModel);
}
