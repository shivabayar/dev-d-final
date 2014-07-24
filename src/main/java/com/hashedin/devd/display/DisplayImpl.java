package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Repository;

import com.hashedin.devd.integration.CommitedAt;

@Repository
@Service
public class DisplayImpl implements DisplayInterface {

	@Override
	public String frequencyCalculator(List<String> CreatedAtList) {
		int localCounter = 0;
		CommitedAt commmitedAt = new CommitedAt();
		String createdAt = "";
		int count[] = new int[8];
		try {
			for (int i = 0; i < CreatedAtList.size(); ++i) {
				createdAt = CreatedAtList.get(i);
				localCounter = (int) commmitedAt
						.dayDifferenceCalculator(createdAt);
				if (localCounter < 7 && localCounter != 998800) {
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