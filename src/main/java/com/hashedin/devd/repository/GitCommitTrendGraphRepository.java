package com.hashedin.devd.repository;

import java.util.Map;

public interface GitCommitTrendGraphRepository {
	Map<String, Integer> collectCommitGraph();

	String collectCommitGraph(String userName);

	String pushCommitGraph(String userName);
}
