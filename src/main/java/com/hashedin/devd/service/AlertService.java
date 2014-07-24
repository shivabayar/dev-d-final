package com.hashedin.devd.service;

import java.util.List;

import com.hashedin.devd.model.Alert;

/**
 * The Interface AlertService.
 */
public interface AlertService {

	/**
	 * Save.
	 *
	 * @param alert the alert
	 * @param userName the user name
	 */
	void save(Alert alert , String userName);

	/**
	 * Find.
	 *
	 * @param userName the user name
	 * @return the list
	 */
	List<Alert> find(String userName);
}
