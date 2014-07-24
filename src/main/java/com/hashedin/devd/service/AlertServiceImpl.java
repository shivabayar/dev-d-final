package com.hashedin.devd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.repository.AlertRepository;

/**
 * The Class AlertServiceImpl.
 */
@Repository
@Service("alertService")
public class AlertServiceImpl implements AlertService {

	/** The alert repository. */
	@Autowired
	private AlertRepository alertRepository;

	/* (non-Javadoc)
	 * @see com.hashedin.devd.service.AlertService#save
	 * (com.hashedin.devd.model.Alert, java.lang.String)
	 */
	@Override
	public final void save(final Alert alert , final String userName) {
		alertRepository.save(alert , userName);

	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.service.AlertService#find(java.lang.String)
	 */
	@Override
	public final List<Alert> find(final String userName) {
		return alertRepository.find(userName);
	}

}
