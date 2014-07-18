package com.hashedin.devd.alert;

import java.util.List;
import com.hashedin.devd.integration.CommitedAt;

public class AlertFunction implements AlertInterface {

	// get recent commited At from database
@Override
	public int lastCommitedAt(String createdAt) {
		long l;
		CommitedAt commitedAt = new CommitedAt();
		l = commitedAt.dayDifferenceCalculator(createdAt);
		return (int) l;
	}

	// get data list of createdata from data base
@Override
	public Boolean isFrequentComits(List<String> CreatedAtList){
		int l = 0, preDiff = 0, count = 0, pre = 0;
		float avg = 0;
		CommitedAt commitedAt = new CommitedAt();

		for (String createdAt : CreatedAtList) {
			l = (int) commitedAt.dayDifferenceCalculator(createdAt);
			preDiff = l - pre;
			pre = l;
			avg = preDiff / count;
			count++;
		}
		return avg > 2 ? false : true;
	}

}
