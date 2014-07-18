package com.hashedin.devd.integration;

import com.hashedin.devd.realdata.JavaUrlConnectionReader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommitedAt {

	
	
	//get recent commited At from database
	
	
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

	
	
	public void frequencyCalculator() {
	//	JavaUrlConnectionReader realData = new JavaUrlConnectionReader();
	//	String output = realData.getUrlContents("userName");

		long l = 0;
		List<Integer> a = new ArrayList<Integer>();

		String createdAt = "";
		JSONArray jArray;
		/*try {
			jArray = new JSONArray(output);

			for (int i = jArray.length() - 1; i > 7; --i) {

				createdAt = createdAt(output, i);
				l = dayDifferenceCalculator(createdAt);

				int j;

				j = (int) l;

				a[j]++;

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	public long dayDifferenceCalculator(String createdAt) {

		long diffdays = 0;

		createdAt = createdAt.replace('T', ' ');

		StringBuilder sb = new StringBuilder(createdAt);
		sb.deleteCharAt(19);
		String resultString = sb.toString();

		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = null;
		try {
			d1 = df2.parse(resultString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date d2 = new Date();

		long diff = d2.getTime() - d1.getTime();

		diffdays = diff / (24 * 60 * 60 * 1000);

		return diffdays;
	}
}
