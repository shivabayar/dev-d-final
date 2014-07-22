package com.hashedin.devd.repository;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Repository;

import com.hashedin.devd.display.DisplayList;
import com.hashedin.devd.integration.CreateGitModelObject;
import com.hashedin.devd.model.GitModel;

@Repository
@Service
public class ActivityRepoImpl implements ActivityRepo {

	@Override
	public String activity(String userName) {

		CreateGitModelObject createGitModelObject = new CreateGitModelObject();

		List<GitModel> listGitModel = createGitModelObject
				.gitModelObject(userName);

		GitModel gitModel = new GitModel();

		return gitModel.getEventType();
	}
}
