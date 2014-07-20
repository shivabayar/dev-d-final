package com.hashedin.devd.alert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;
import com.hashedin.devd.alert.AlertFunction;

@Service
@Repository
public class AlertFilter {

	public List<String> CreatedAtList;

	public Alert createFilter(List<GitModel> gitModel) {

		Alert a = new Alert();
		AlertFunction alert = new AlertFunction();
		CreatedAtList = new ArrayList<String>();
		long tempId=0;
		String url=null;
		String name=null;
		for (GitModel model : gitModel) {
			CreatedAtList.add(model.getCreatedAt());
			if(model.getGitUserId() != 0){
				tempId=model.getGitUserId();
				url=model.getUserGitUrl();
				name=model.getUserName();
			}
		}
		GitModel model = gitModel.get(1);
		String createdAt = model.getCreatedAt();
		a.setLastCommitedAt(alert.lastCommitedAt(createdAt));
//		System.out.println("\n\n\n\n\n"+a.getLastCommitedAt());
		a.setIsFrequentCommits(alert.isFrequentComits(CreatedAtList));
		a.setGitUserId(tempId);
		a.setUrl(url);
		a.setUserName(name);
		return a;
	}

	public List<String> getCreatedAtList() {
		return CreatedAtList;
	}

}
