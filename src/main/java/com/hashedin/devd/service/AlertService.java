package com.hashedin.devd.service;

import java.util.List;

import com.hashedin.devd.model.Alert;

public interface AlertService {
	List<Alert> findAll();
	void save(Alert alert,String userName);
	List<Alert> find(String userName);
}
