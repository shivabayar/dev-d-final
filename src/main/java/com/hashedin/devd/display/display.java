package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.List;

import com.hashedin.devd.model.Display;

public class display {

	public Display display() {
// get list from db
		
		
		DisplayImpl display = new DisplayImpl();
		ArrayList<Integer> displayList = display
				.frequencyCalculator(CreatedAtList);

		Display d = new Display();
		d.setDisplayList(displayList);

		return d;

	}

}
