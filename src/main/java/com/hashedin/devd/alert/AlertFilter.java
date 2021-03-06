package com.hashedin.devd.alert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;


//import com.hashedin.devd.alert.AlertsImpl;

/**
 * The Class AlertFilter.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
@Service
@Repository
public class AlertFilter {

/**
*list of string.
*/
private List<String> createdAtList;

/**
 * Filters the list of git model calculates, lastcommited at frequent Short
 * (1) one line description. (1) commits
 *
 * @param gitModel the git model
 * @return Alert object
 */
public final Alert createFilter(final List<GitModel> gitModel) {
	Alert a = new Alert();
	AlertsImpl alert = new AlertsImpl();
	createdAtList = new ArrayList<String>();
	long tempId = 0;
	String url = null;
	String name = null;
	String createdAt = null;
	boolean isRececentDate = false;
	for (GitModel model : gitModel) {
		createdAtList.add(model.getCreatedAt());
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
	a.setIsFrequentCommits(alert.isFrequentComits(createdAtList));
	a.setGitUserId(tempId);
	a.setUrl(url);
	a.setUserName(name);
	return a;
}
}
