package com.hashedin.devd.alert;
import com.hashedin.devd.alert.AlertInterface;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hashedin.devd.integration.CommitedAt;
import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitCommit;
import com.hashedin.devd.alert.AlertFunction;

@Service
@Repository
public class AlertFilter {

	public Alert createFilter(){

		Alert a = new Alert();
		AlertFunction alert = new AlertFunction();
		
		//get list fro db
	
		
		
		a.setLastCommitedAt(alert.lastCommitedAt(createdAt);
		a.setisFrequentCommits(alert.isFrequentComits(CreatedAtList));

		
		return a;
	}


	
	
	public List<Alert> createAlerts(List<GitCommit> commits) {
		// TODO Auto-generated method stub
		return null;
	}
}