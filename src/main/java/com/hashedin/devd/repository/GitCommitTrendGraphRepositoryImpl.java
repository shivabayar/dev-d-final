package com.hashedin.devd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hashedin.devd.display.DisplayList;
import com.hashedin.devd.model.GitModel;
/**
 * The Class GitCommitTrendGraphRepositoryImpl.
 */
@Repository
public class GitCommitTrendGraphRepositoryImpl implements
GitCommitTrendGraphRepository {

	/** The display trend graph. */
	private DisplayList displayTrendGraph = new DisplayList();

	/** The collect repository. */
	@Autowired
	private CollectRepository collectRepository;

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .GitCommitTrendGraphRepository#collectCommitGraph(java.lang.String)
	 */
	@Override
	public final String collectCommitGraph(final String userName) {
		return displayTrendGraph
				.displayCommitTrendGraphFilter(
						listGitModel(userName));
	}

	/**
	 * List git model.
	 *
	 * @param userName the user name
	 * @return the list
	 */
	public final List<GitModel> listGitModel(final String userName) {
		return collectRepository.find(userName);
	}

	/* (non-Javadoc)
	 * @see com.hashedin.devd.repository
	 * .GitCommitTrendGraphRepository#pushCommitGraph(java.lang.String)
	 */
	@Override
	public final String pushCommitGraph(final String userName) {
		return displayTrendGraph
				.displayPullGraphFilter(listGitModel(userName));
	}

}