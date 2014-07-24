package com.hashedin.devd.repository;

import java.util.List;
import com.hashedin.devd.model.Alert;
/**
 * The Interface AlertRepository.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
public interface AlertRepository {

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param userName the user name
	 */
	void delete(String userName);

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param userName the user name
	 * @return string
	 */
	List<Alert> find(String userName);

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param alert the alert
	 * @param userName the user name
	 */
	void save(Alert alert, String userName);
}