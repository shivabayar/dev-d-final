package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.List;
import com.hashedin.devd.integration.CommitedAt;

public class DisplayImpl implements DisplayInterface {

	@Override
	public ArrayList<Integer> frequencyCalculator(List<String> CreatedAtList) {
		int l = 0;
		CommitedAt commmitedAt = new CommitedAt();
		
		System.out.println("in frrequency calci");

		ArrayList<Integer> a = new ArrayList<Integer>();
		try {
			for (int i = 0; i < CreatedAtList.size();++i) {

				String createdAt = CreatedAtList.get(i);
	//			System.out.println("inside forloop" + createdAt);
				l = (int) commmitedAt.dayDifferenceCalculator(createdAt);
				if (l < 8) {
					a.set(l, a.get(l) + 1);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		//System.out.println("returning arraylist" + a);

		return a;
	}
}
