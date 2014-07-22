package com.hashedin.devd.repository;

import java.util.List;
import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;

public interface CollectRepository {
	Alert save(Alert alert);

	void collect(String useName);

	void save(List<GitModel> gitModel, String username);

	List<GitModel> find(String username);

	void delete(String username);

	void delete();

	List<GitModel> listAll();
}
