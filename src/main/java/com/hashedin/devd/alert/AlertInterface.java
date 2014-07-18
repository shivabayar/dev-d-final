package com.hashedin.devd.alert;

import java.util.List;

public interface AlertInterface {

	int lastCommitedAt(String createdAt);

	Boolean isFrequentComits(List<String> CreatedAtList);

}
