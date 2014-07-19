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
	
		System.out.println("/n/n/n/n"+ "entry to frequency calci");
		
		for (String createdAt : CreatedAtList) {
			l = (int) commmitedAt.dayDifferenceCalculator(createdAt);
			if (l < 8 && l!= 0) {
				a.set(l, a.get(l) + 1);
			}
			
		}
		
		System.out.println("freq list"+ a);
		
		return a;
	}
}
