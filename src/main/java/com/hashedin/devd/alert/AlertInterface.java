package com.hashedin.devd.alert;

import java.util.List;

/**
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
public interface AlertInterface {

	int lastCommitedAt(String createdAt);

	Boolean isFrequentComits(List<String> CreatedAtList);
}