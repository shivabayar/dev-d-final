package com.hashedin.devd.integration;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hashedin.devd.model.GitModel;
import com.hashedin.devd.realdata.JavaUrlConnectionReader;

public class CreateGitModelObject {

	public List<GitModel> gitModelObject(String userName) {
		JavaUrlConnectionReader realData = new JavaUrlConnectionReader();

		String output = realData.getUrlContents(userName);

		List<GitModel> modelObjList = new ArrayList<GitModel>();
		// GitModel gitModel = new GitModel();
		JSONArray jArray;
		try {
			jArray = new JSONArray(output);

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject jsonObj = jArray.getJSONObject(i);
				String type = (String) jsonObj.get("type");
				String url;
				GitModel gitModel = new GitModel();
				if (type.endsWith("PushEvent")
						|| type.endsWith("PullRequestEvent")) {

					String createdAt1 = (String) jsonObj.get("created_at");

					gitModel.setCreatedAt(createdAt1);
					gitModel.setEventType(type);
					if (type.endsWith("PullRequestEvent")) {
						JSONObject jsonObj1 = jsonObj.getJSONObject("payload");
						JSONObject jsonObj2 = jsonObj1
								.getJSONObject("pull_request");
						JSONObject jsonObj3 = jsonObj.getJSONObject("actor");
						String type2 = (String) jsonObj3.get("url");
						int  type1 =  (Integer) jsonObj3.get("id");
						gitModel.setUserGitUrl(type2);
						//gitModel.setGitUserId(type1);
						Boolean merged = (Boolean) jsonObj2.get("merged");

						gitModel.setPullAction(merged);
						
					} else {

						gitModel.setPullAction(true);
					}
				}
				modelObjList.add(gitModel);
				System.out.println(gitModel);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		return modelObjList;
	}

}
