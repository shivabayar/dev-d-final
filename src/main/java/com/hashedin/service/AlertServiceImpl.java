package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashedin.model.Alert;
import com.hashedin.repository.AlertRepository;

@Service("alertService")
public class AlertServiceImpl implements AlertService {

	@Autowired
	private AlertRepository alertRepository;
	
	@Override
	public List<Alert> findAll() {
		return alertRepository.findAll();
	}

	@Override
	public Alert save(Alert alert) {
		alertRepository.save(alert);
		return alert;
	}

}
