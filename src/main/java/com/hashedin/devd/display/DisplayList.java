package com.hashedin.devd.display;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hashedin.devd.model.GitModel;

public class DisplayList {

	private Map<String, Integer> displayList; 
	public void displayFilter(List<GitModel> gitModel) {
		DisplayImpl display = new DisplayImpl();
		displayList = new HashMap<String, Integer>();
		List<String> createdAtList = new ArrayList<String>();
		for (GitModel model : gitModel) {
			createdAtList.add(model.getCreatedAt());
		}
		setDisplayList(display.frequencyCalculator(createdAtList));
		//this.displayList = display.frequencyCalculator(createdAtList);
		System.out.println("in disp filter" + displayList);
	}

	public Map<String, Integer> getDisplayList() {
		System.out.println(" in displist" + displayList);
		return this.displayList;
	}

	public void setDisplayList(Map<String, Integer> displayList) {
		this.displayList = displayList;
	}
}