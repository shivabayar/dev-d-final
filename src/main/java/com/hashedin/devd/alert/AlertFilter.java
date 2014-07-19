package com.hashedin.devd.alert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import scala.Array;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;
import com.hashedin.devd.alert.AlertFunction;

@Service
@Repository
public class AlertFilter {

	private List<String> CreatedAtList;// = new ArrayList<String>();;
	//private AlertFilter alertFilter=new AlertFilter();
//	public AlertFilter() {
//		CreatedAtList = new ArrayList<String>();
//	}

	public Alert createFilter(List<GitModel> gitModel) {

		Alert a = new Alert();
		AlertFunction alert = new AlertFunction();
		List<String> tempList=new ArrayList<String>();
		for (GitModel model : gitModel) {
			tempList.add(model.getCreatedAt());
		}
		setCreatedAtList(tempList);
		int i = getCreatedAtList().size()-1;//CreatedAtList.size()-1;
		GitModel model = gitModel.get(i);
		String createdAt = model.getCreatedAt();
		a.setLastCommitedAt(alert.lastCommitedAt(createdAt));
		a.setFrequentCommits(alert.isFrequentComits(getCreatedAtList()));//CreatedAtList));

		return a;
	}

	public void setCreatedAtList(List<String> createdAtList) {
		CreatedAtList = createdAtList;
	}

	public List<String> getCreatedAtList() {
		System.out.println("CreatedAtList jylhlugdufhitgjtgjiuj "+CreatedAtList);
		
		return CreatedAtList;
	}

}