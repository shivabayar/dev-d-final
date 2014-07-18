package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.List;
import com.hashedin.devd.integration.CommitedAt;

public class DisplayImpl implements DisplayInterface {

	@Override
	public ArrayList<Integer> frequencyCalculator(List<String> CreatedAtList) {
		int l = 0;
		CommitedAt commmitedAt = new CommitedAt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (String createdAt : CreatedAtList) {
			l = (int) commmitedAt.dayDifferenceCalculator(createdAt);
			if (l < 8) {
				a.set(l, a.get(l) + 1);
			}
		}
		return a;
	}
}
