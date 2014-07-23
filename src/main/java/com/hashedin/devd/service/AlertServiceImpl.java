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
	public void save(Alert alert,String userName) {
		alertRepository.save(alert,userName);
		
	}

	@Override
	public List<Alert> find(String userName) {
		return alertRepository.find(userName);
	}

}
