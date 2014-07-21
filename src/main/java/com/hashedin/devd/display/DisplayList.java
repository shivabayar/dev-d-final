package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.hashedin.devd.model.GitModel;

public class DisplayList {

	private String displayList;

	public String displayList() {

		System.out.println(" in displist" + displayList);
		return displayList;
	}

	public String displayFilter(List<GitModel> gitModel) {
		DisplayImpl display = new DisplayImpl();
		displayList = new String();
		List<String> createdAtList = new ArrayList<String>();
		for (GitModel model : gitModel) {
			createdAtList.add(model.getCreatedAt());
		}

		System.out.println("in disp filter" + displayList);

		return displayList = display.frequencyCalculator(createdAtList);
	}
}