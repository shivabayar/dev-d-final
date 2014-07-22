package com.hashedin.devd.integration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommitedAt {

	public long dayDifferenceCalculator(String createdAt) {

		long dateDiffInDays = 0;
		try {
			if (createdAt != null) {
				createdAt = createdAt.replace('T', ' ');
				StringBuilder sb = new StringBuilder(createdAt);
				sb.deleteCharAt(19);
				String resultString = sb.toString();
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date nextDay = new Date();
				Date previousDay = null;
				previousDay = df2.parse(resultString);
				long dateDiff = nextDay.getTime() - previousDay.getTime();
				dateDiffInDays = dateDiff / (24 * 60 * 60 * 1000);
			} else {
				dateDiffInDays = 998800;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateDiffInDays;
	}
}
