package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.hashedin.devd.integration.CommitedAt;

public class DisplayImpl implements DisplayInterface {

	@Override
	public String frequencyCalculator(List<String> CreatedAtList) {
		int l = 0;
		CommitedAt commmitedAt = new CommitedAt();
		String createdAt = "";
		int count[] = new int[8];
		try {
			for (int i = 0; i < CreatedAtList.size(); ++i) {
				createdAt = CreatedAtList.get(i);
				l = (int) commmitedAt.dayDifferenceCalculator(createdAt);
				if (l < 7  && l != 998800) {
					count[l] = ++count[l];
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int currentIndex = day;
		JSONObject weekMap = new JSONObject();
		List<String> nameOfDay = new ArrayList<String>();
		nameOfDay.add("zero");nameOfDay.add("one");nameOfDay.add("two");nameOfDay.add("three");
		nameOfDay.add("four");nameOfDay.add("five");
		nameOfDay.add("six");
		do {
			try {
				weekMap.put(nameOfDay.get(currentIndex), count[currentIndex]);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentIndex++;
			if (currentIndex > nameOfDay.size() - 1) {
				currentIndex = 0;
			}
		} while (currentIndex != day);
	
		System.out.println(weekMap);
	
		return weekMap.toString();
		
		//return weekMap;
	}
}