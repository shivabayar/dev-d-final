package com.hashedin.devd.integration;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hashedin.devd.model.GitModel;
import com.hashedin.devd.realdata.JavaUrlConnectionReader;

/**
 * The Class CreateGitModelObject.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
public class CreateGitModelObject {

/**
 * Git model object.
 *
 * @param userName the user name
 * @return Description text text text.
 */
	public final List<GitModel> gitModelObject(final String userName) {
		JavaUrlConnectionReader realData;
		realData = new JavaUrlConnectionReader();
		String output = realData.getUrlContents(userName);

		// System.out.println("in git model object");
		// System.out.println("output "+output);
		List<GitModel> modelObjList = new ArrayList<GitModel>();
		JSONArray jArray;
		try {
			int type = 0;
			jArray = new JSONArray(output);
			for (int count = 0; count < jArray.length(); count++) {
				JSONObject jsonObj = jArray.
						getJSONObject(count);
				String eventType = (String) jsonObj.get("type");
				GitModel gitModel = new GitModel();
				type = (Integer) (jsonObj
						.getJSONObject("actor")
						.get("id"));
				if (eventType.endsWith("PushEvent")
						|| eventType
						.endsWith("PullRequestEvent")) {
					String createdAt = (String) jsonObj
							.get("created_at");
					gitModel.setCreatedAt(createdAt);
					gitModel.setEventType(eventType);
					JSONObject jsonObj3 = jsonObj
							.getJSONObject("actor");
					String url = (String) jsonObj3
							.get("url");
					gitModel.setUserGitUrl(url);
					type = (Integer) jsonObj3.get("id");
					gitModel.setGitUserId(type);
					gitModel.setUserName(userName);
					if (eventType
							.endsWith(
							"PullRequestEvent")) {
						JSONObject payLoadJsonObj;
						payLoadJsonObj = jsonObj
						.getJSONObject("payload");
						JSONObject pullRequestJson;
						pullRequestJson = payLoadJsonObj
						.getJSONObject("pull_request");
						Boolean merged;
					merged = (Boolean) pullRequestJson
								.get("merged");
						gitModel.setPullAction(merged);
					} else {
						gitModel.setPullAction(true);
					}
				}
				modelObjList.add(gitModel);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return modelObjList;
	}
}
