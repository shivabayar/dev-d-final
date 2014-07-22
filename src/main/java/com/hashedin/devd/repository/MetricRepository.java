package com.hashedin.devd.repository;

import java.util.List;

import com.hashedin.devd.model.GitMetric;

public interface MetricRepository {
	List<GitMetric> findAll();
	GitMetric save(GitMetric metric);
}
