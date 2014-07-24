package com.hashedin.devd.repository;

import java.util.List;
import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;

/**
 * The Interface CollectRepository.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
public interface CollectRepository {

	/**
	 * Collect.
	 *
	 * @param useName the use name
	 */
	void collect(String useName);

	/**
	 * Save.
	 *
	 * @param gitModel the git model
	 * @param username the username
	 */
	void save(List<GitModel> gitModel, String username);

	/**
	 * Short one line description. (1)
	 * <p>
	 * Longer description. If there were any, it would be [2] here.
	 * <p>
	 * by HTML paragraph breaks.
	 *
	 * @param username the username
	 * @return string
	 */
	List<GitModel> find(String username);

	/**
	 * Short one line description. (1)
	 * <p>
	 * Longer description. If there were any, it would be [2] here.
	 * <p>
	 * by HTML paragraph breaks.
	 *
	 * @param username the username
	 */
	void delete(String username);

	/**
	 * Short one line description. (1)
	 * <p>
	 * Longer description. If there were any, it would be [2] here.
	 * <p>
	 * by HTML paragraph breaks.
	 */
	void delete();

	/**
	 * Short one line description. (1)
	 * <p>
	 * Longer description. If there were any, it would be [2] here.
	 * <p>
	 * by HTML paragraph breaks.
	 *
	 * @return string
	 */
	List<GitModel> listAll();
}
