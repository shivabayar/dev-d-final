package com.hashedin.devd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.repository.AlertRepository;

@Repository
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

	@Override
	public Alert find(long userid) {
		alertRepository.find(userid);
		return null;
	}

}
