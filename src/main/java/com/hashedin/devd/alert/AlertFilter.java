package com.hashedin.devd.alert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;
import com.hashedin.devd.alert.AlertsImpl;


//sdfasdfsda
@Service
@Repository
public class AlertFilter {

	public List<String> CreatedAtList;

	public Alert createFilter(List<GitModel> gitModel) {
		Alert a = new Alert();
		AlertsImpl alert = new AlertsImpl();
		CreatedAtList = new ArrayList<String>();
		long tempId = 0;
		String url = null;
		String name = null;
		String createdAt = null;
		boolean isRececentDate = false;
		for (GitModel model : gitModel) {
			CreatedAtList.add(model.getCreatedAt());
			if (model.getGitUserId() != 0) {
				tempId = model.getGitUserId();
				url = model.getUserGitUrl();
				name = model.getUserName();
			}
			if (model.getCreatedAt() != null && !isRececentDate) {
				createdAt = model.getCreatedAt();
				isRececentDate = true;
			}

		}
		a.setLastCommitedAt(alert.lastCommitedAt(createdAt));
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
