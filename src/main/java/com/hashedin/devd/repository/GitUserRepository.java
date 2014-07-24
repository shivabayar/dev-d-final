package com.hashedin.devd.repository;

import java.util.List;

import com.hashedin.devd.model.GitUser;

/**
 * The Interface GitUserRepository.
 */
public interface GitUserRepository {

	/**
	 * Find.
	 *
	 * @param gitUserId the git user id
	 * @return the git user
	 */
	GitUser find(Long gitUserId);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<GitUser> findAll();

	/**
	 * Save.
	 *
	 * @param gitUser the git user
	 * @return the git user
	 */
	GitUser save(GitUser gitUser);

	/**
	 * Delete.
	 *
	 * @param gitUserId the git user id
	 * @return the git user
	 */
	GitUser delete(Long gitUserId);

	/**
	 * Find.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the git user
	 */
	GitUser find(String email, String password);

	/**
	 * Find.
	 *
	 * @param username the username
	 * @return the git user
	 */
	GitUser find(String username);
}
