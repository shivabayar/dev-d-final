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
		return displayList;
	}

	public String displayCommitTrendGraphFilter(List<GitModel> gitModel) {
		DisplayImpl display = new DisplayImpl();
		displayList = new String();
		List<String> createdAtList = new ArrayList<String>();
		boolean isNull = false;
		try {
			for (GitModel model : gitModel) {
				String s = model.getEventType();
				if (s.endsWith("PushEvent") && (isNull == s.equals(null))) {
					createdAtList.add(model.getCreatedAt());
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return displayList = display.frequencyCalculator(createdAtList);
	}

	public String displayPullGraphFilter(List<GitModel> gitModel) {
		DisplayImpl display = new DisplayImpl();
		displayList = new String();
		List<String> createdAtList = new ArrayList<String>();
		boolean isNull = false;
		try {
			for (GitModel model : gitModel) {
				String s = model.getEventType();
				if (s.endsWith("PullRequestEvent")
						&& (isNull == s.equals(null))) {
					createdAtList.add(model.getCreatedAt());
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return displayList = display.frequencyCalculator(createdAtList);
	}
}