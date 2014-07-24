package com.hashedin.devd.alert;

import java.util.List;
import com.hashedin.devd.integration.CommitedAt;

/**
 * The Class AlertsImpl.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
public class AlertsImpl implements AlertInterface {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.hashedin.devd.alert
	 * .AlertInterface#lastCommitedAt(java.lang.String)
	 */
	@Override
	public final int lastCommitedAt(final String createdAt) {
		long l;
		CommitedAt commitedAt = new CommitedAt();
		l = commitedAt.dayDifferenceCalculator(createdAt);
		return (int) l;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.hashedin.devd.alert
	 * .AlertInterface#isFrequentComits(java.util.List)
	 */
	@Override
	public final Boolean isFrequentComits(final List<String> createdList) {
		int l = 0, preDiff = 0, count = 1, pre = 0;
		float avg = 0;
		try {
			CommitedAt commitedAt = new CommitedAt();
			for (int i = 0; i < createdList.size(); ++i) {
				String createdAt = createdList.get(i);
				l = (int) commitedAt
					.dayDifferenceCalculator(createdAt);
				final int temp = 998800;
				if (i > 1 && l != temp) {
					preDiff = l - pre;
					pre = l;
					avg = preDiff / count;
					count++;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		final boolean result = (avg > 2 ? false : true);
		return result;
	}
}