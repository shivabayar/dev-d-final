package com.hashedin.devd.integration;

import com.hashedin.devd.realdata.JavaUrlConnectionReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommitedAt {

	
	public int lastCommitedAt(String userName) {

		JavaUrlConnectionReader realData = new JavaUrlConnectionReader();
		String output = realData.getUrlContents("userName");

		long l = 0;
		String createdAt = "";
		JSONArray jArray;
		try {
			jArray = new JSONArray(output);
			createdAt = createdAt(output, jArray.length() - 1);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		l = dayDifferenceCalculator(createdAt);
		return (int) l;
	}

	public String createdAt(String output, int i) {

		String createdAt = "";
		JSONArray jArray;

		try {
			jArray = new JSONArray(output);

			JSONObject jsonObj = jArray.getJSONObject(i);

			createdAt = (String) jsonObj.get("created_at");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return createdAt;
	}

	
	public long dayDifferenceCalculator(String createdAt) {

		long diffdays = 0;

		if(createdAt != null){
	
		createdAt = createdAt.replace('T', ' ');
		StringBuilder sb = new StringBuilder(createdAt);
		sb.deleteCharAt(19);
		String resultString = sb.toString();
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		Date d2 = new Date();
		Date d1 = null;
		if (d2.equals(d1)){
		try {
			d1 = df2.parse(resultString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long diff = d2.getTime() - d1.getTime();
		diffdays = diff / (24 * 60 * 60 * 1000);
		}
		}
		return diffdays;
	}
}
