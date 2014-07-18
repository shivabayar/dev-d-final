package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.List;

import com.hashedin.devd.alert.AlertFilter;

public class DisplayList {

	public ArrayList<Integer> displayList() {
		ArrayList<Integer> displayList= new ArrayList<Integer>();
		AlertFilter af = new AlertFilter();
		DisplayImpl display = new DisplayImpl();
		List<String> createdAt= new ArrayList<String>();
		
		createdAt = af.getCreatedAtList();
		System.out.println("entyr into displaylist"+ af.getCreatedAtList());
		
		displayList = display.frequencyCalculator(createdAt);

		
		return displayList;
	}

}
