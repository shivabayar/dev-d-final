package com.hashedin.devd.display;

import java.util.List;
import com.hashedin.devd.integration.CommitedAt;

public class DisplayImpl implements DisplayInterface {

	@Override
	public int[] frequencyCalculator(List<String> CreatedAtList) {
		int l = 0;
		CommitedAt commmitedAt = new CommitedAt();
		String createdAt = "";
		int b[]=new int[8];
		
		try {
			for (int i = 0; i < CreatedAtList.size(); ++i) {
				createdAt = CreatedAtList.get(i);
				l = (int) commmitedAt.dayDifferenceCalculator(createdAt);
				if (l < 6 || l == 0) {
					b[l]=++b[l];
					}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return b;
	}
}
