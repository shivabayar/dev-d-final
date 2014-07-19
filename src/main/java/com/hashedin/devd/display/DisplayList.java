package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.List;

import com.hashedin.devd.model.GitModel;

public class DisplayList {

	 private ArrayList<Integer> displayList;

	public ArrayList<Integer> displayList() {
		return displayList;
	}

	public void displayFilter(List<GitModel> gitModel) {

		DisplayImpl display = new DisplayImpl();
		List<String> createdAtList = new ArrayList<String>();
		for (GitModel model : gitModel) {
			createdAtList.add(model.getCreatedAt());
		}

		System.out.println("in display filter ");
		
		displayList = display.frequencyCalculator(createdAtList);

		System.out.println("after getting display list "+ displayList);
		
	}
}