package com.hashedin.devd.display;

import java.util.ArrayList;

import com.hashedin.devd.alert.AlertFilter;

public class DisplayList {

	public ArrayList<Integer> displayList() {

		AlertFilter af = new AlertFilter();
		DisplayImpl display = new DisplayImpl();
		ArrayList<Integer> displayList = display.frequencyCalculator(af
				.getCreatedAtList());

		return displayList;
	}

}
