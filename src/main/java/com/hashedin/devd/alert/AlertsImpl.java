package com.hashedin.devd.alert;

import java.util.List;

import com.hashedin.devd.integration.CommitedAt;

public class AlertsImpl implements AlertInterface {

	@Override
	public int lastCommitedAt(String createdAt) {
		long l;
		CommitedAt commitedAt = new CommitedAt();
		l = commitedAt.dayDifferenceCalculator(createdAt);
		return (int) l;
	}

	@Override
	public Boolean isFrequentComits(List<String> CreatedAtList) {
		int l = 0, preDiff = 0, count = 1, pre = 0;
		float avg = 0;
		try {
			CommitedAt commitedAt = new CommitedAt();
			for (int i = 0; i < CreatedAtList.size(); ++i) {
				String createdAt = CreatedAtList.get(i);
				l = (int) commitedAt.dayDifferenceCalculator(createdAt);
				if (i > 1 && l != 998800) {
					preDiff = l - pre;
					pre = l;
					avg = preDiff / count;
					count++;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return avg > 2 ? false : true;
	}
}