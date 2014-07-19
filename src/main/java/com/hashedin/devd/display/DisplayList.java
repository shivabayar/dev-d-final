package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.List;

import com.hashedin.devd.model.GitModel;

public class DisplayList {

	private int[] displayList;

	public int[] displayList() {
		return displayList;
	}

	public void displayFilter(List<GitModel> gitModel) {

		DisplayImpl display = new DisplayImpl();
		List<String> createdAtList = new ArrayList<String>();
		for (GitModel model : gitModel) {
			createdAtList.add(model.getCreatedAt());
		}
		displayList = display.frequencyCalculator(createdAtList);
		
	}
}
