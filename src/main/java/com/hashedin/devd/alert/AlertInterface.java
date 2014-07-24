package com.hashedin.devd.alert;

import java.util.List;


/**
 * The Interface AlertInterface.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
public interface AlertInterface {

	/**
	 * Last commited at.
	 *
	 * @param createdAt
	 *            the created at
	 * @return the int
	 */
	int lastCommitedAt(String createdAt);

	/**
	 * Checks if is frequent comits.
	 *
	 * @param createdAtList
	 *            the created at list
	 * @return the boolean
	 */
	Boolean isFrequentComits(List<String> createdAtList);
}