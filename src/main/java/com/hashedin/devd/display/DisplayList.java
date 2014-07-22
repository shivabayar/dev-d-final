package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hashedin.devd.model.GitModel;

public class DisplayList {

//	private String displayJsonList = new String();
	@Autowired
	private DisplayImpl display = new DisplayImpl();
	
	

	public String displayCommitTrendGraphFilter(List<GitModel> gitModel) {
		
		
		return display.frequencyCalculator(createList(gitModel,"PushEvent"));
	}

	public String displayPullGraphFilter(List<GitModel> gitModel) {
		
		return display.frequencyCalculator(createList(gitModel,"PullRequestEvent"));
	}


	public List<String> createList(List<GitModel> gitModel,String event){
		List<String> createdAtList = new ArrayList<String>();
		boolean isNull = false;
		try {
			for (GitModel model : gitModel) {
				String s = model.getEventType();
				if (s.endsWith(event) && (isNull == s.equals(null))) {
					createdAtList.add(model.getCreatedAt());
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return createdAtList;
	}
}