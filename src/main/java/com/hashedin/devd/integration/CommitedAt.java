package com.hashedin.devd.integration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The Class CommitedAt.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
public class CommitedAt {

	/**
	 * Day difference calculator.
	 *
	 * @param createdAt 		 (3)
	 * @return dateDiffInDays
	 */
	public final long dayDifferenceCalculator(String createdAt) {
		long dateDiffInDays = 0;
		final int deleteCharAt = 19;
		final int ddid = 998800;
		final int hours = 24;
		final int minutes = 60;
		final int seconds = 60;
		final int milliseconds = 1000;
		int res = (hours * minutes * seconds * milliseconds);

		try {
			if (createdAt != null) {
				createdAt = createdAt.replace('T', ' ');
				StringBuilder sb = new StringBuilder(createdAt);
				sb.deleteCharAt(deleteCharAt);
				String resultString = sb.toString();
				DateFormat df2;
				df2 = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date nextDay = new Date();
				Date previousDay = null;
				previousDay = df2.parse(resultString);
				long dateDiff = nextDay.getTime()
						- previousDay.getTime();
				dateDiffInDays = dateDiff / res;

			} else {
				dateDiffInDays = ddid;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateDiffInDays;
	}
}