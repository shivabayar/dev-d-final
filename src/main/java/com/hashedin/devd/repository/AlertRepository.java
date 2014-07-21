package com.hashedin.devd.repository;

import java.util.List;

import com.hashedin.devd.model.Alert;


public interface AlertRepository {
	List<Alert> findAll();
	void save(List<Alert> alertList);
	Alert update(Alert alert, Long alertId);
	void delete(String userName);
	List<Alert> find(String userName);
	void save(Alert alert,String userName);
}