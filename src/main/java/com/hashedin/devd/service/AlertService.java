package com.hashedin.devd.service;

import java.util.List;

import com.hashedin.devd.model.Alert;

public interface AlertService {
	List<Alert> findAll();
	Alert save(Alert alert);
	List<Alert> find(String userName);
}
