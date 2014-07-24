package com.hashedin.devd.repository;
/**
 * The Interface GitCommitTrendGraphRepository.
 */
public interface GitCommitTrendGraphRepository {

	/**
	 * Collect commit graph.
	 *
	 * @param userName the user name
	 * @return the string
	 */
	String collectCommitGraph(String userName);

	/**
	 * Push commit graph.
	 *
	 * @param userName the user name
	 * @return the string
	 */
	String pushCommitGraph(String userName);
}
