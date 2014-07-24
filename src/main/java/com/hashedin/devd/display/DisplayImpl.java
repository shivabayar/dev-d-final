package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Repository;

import com.hashedin.devd.integration.CommitedAt;

/**
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
@Service
@Repository
public class DisplayImpl implements DisplayInterface {

	@Override
	public String frequencyCalculator(final List<String> createdList) {
		int localCounter = 0;
		CommitedAt commmitedAt = new CommitedAt();
		String createdAt = "";
		final int arraySize = 8;
		int[] count = new int[arraySize];
		try {
			for (int i = 0; i < createdList.size(); ++i) {
				createdAt = createdList.get(i);
				localCounter = (int) commmitedAt
						.dayDifferenceCalculator(createdAt);
				final int temp1 = 998800;
				final int temp = 7;
				if (localCounter < temp && localCounter != temp1) {
					count[localCounter] = ++count[localCounter];
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int currentIndex = day;
		JSONObject weekMap = new JSONObject();
		List<String> daysAgo = new ArrayList<String>();
		daysAgo.add("zero");
		daysAgo.add("one");
		daysAgo.add("two");
		daysAgo.add("three");
		daysAgo.add("four");
		daysAgo.add("five");
		daysAgo.add("six");
		do {
			try {
				weekMap.put(daysAgo.get(currentIndex), count[currentIndex]);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			currentIndex++;
			if (currentIndex > daysAgo.size() - 1) {
				currentIndex = 0;
			}
		} while (currentIndex != day);
		return weekMap.toString();
	}
}