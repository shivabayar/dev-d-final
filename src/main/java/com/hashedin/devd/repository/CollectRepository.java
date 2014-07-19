package com.hashedin.devd.repository;

import java.util.List;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;


public interface CollectRepository {

	//List<Alert> findAll();
	Alert save(Alert alert);
	void collect();
	void save(List<GitModel> gitModel);
	List<GitModel> find(Long userId);
}
