package com.hashedin.devd.integration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommitedAt {

	public long dayDifferenceCalculator(String createdAt) {

		long diffdays = 0;
		try {
			if (createdAt != null) {
				createdAt = createdAt.replace('T', ' ');
				StringBuilder sb = new StringBuilder(createdAt);
				sb.deleteCharAt(19);
				String resultString = sb.toString();
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date d2 = new Date();
				Date d1 = null;
				d1 = df2.parse(resultString);
				long diff = d2.getTime() - d1.getTime();
				diffdays = diff / (24 * 60 * 60 * 1000);
			}else{
				diffdays= 998800;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diffdays;
	}
}
