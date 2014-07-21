package com.hashedin.devd.display;

import java.util.List;
import com.hashedin.devd.integration.CommitedAt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hashedin.devd.integration.CommitedAt;

public class DisplayImpl implements DisplayInterface {


	public Map<String, Integer> frequencyCalculator(List<String> CreatedAtList) {
		int l = 0;
		CommitedAt commmitedAt = new CommitedAt();
		String createdAt = "";
		int count[] = new int[8];
		try {
			for (int i = 0; i < CreatedAtList.size(); ++i) {
				createdAt = CreatedAtList.get(i);
				l = (int) commmitedAt.dayDifferenceCalculator(createdAt);
				if (l < 6 || l == 0) {
					count[l] = ++count[l];
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int currentIndex = day;
		Map<String,Integer> weekMap = new HashMap<String, Integer>();
		int data[]=new int[] {1,2,3,4,5,6,7 };
		List<String> nameOfDay = new ArrayList<String>();
		nameOfDay.add("sun");
		nameOfDay.add("mon");
		nameOfDay.add("tue");
		nameOfDay.add("wed");
		nameOfDay.add("thu");
		nameOfDay.add("fri");
		nameOfDay.add("sat");
			
		do {
		//	cal.add(Calendar.DATE, -1);
			System.out.println("inside ");
			weekMap.put(nameOfDay.get(currentIndex), count[currentIndex]);
			currentIndex++;			
			if (currentIndex > nameOfDay.size() - 1) {
		
				System.out.println("inside  if ");
				
				currentIndex = 0;
			}
		} while (currentIndex != day);

		System.out.println(weekMap);

		return weekMap;
	}
}