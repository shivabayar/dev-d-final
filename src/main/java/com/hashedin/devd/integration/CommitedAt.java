package com.hashedin.devd.integration;

import com.hashedin.devd.realdata.JavaUrlConnectionReader;

import java.lang.reflect.Array;
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

	// get recent commited At from database

	public int lastCommitedAt(String createdAt) {
		long l;
		l = dayDifferenceCalculator(createdAt);
		return (int) l;
	}

	
	// get data list of createdata from data base

	public Boolean isFrequentComits(List<String>CreatedAtList){
		
		int l =0,preDiff=0,count=0,pre=0;
		float avg =0;
		
			for (String createdAt :CreatedAtList) {
				
					l = (int) dayDifferenceCalculator(createdAt);
								
					preDiff= l - pre;
					pre = l;
					avg = preDiff/count;					
					count++;
			}
			return avg >2 ? false :true;
	}
	
	
	
	public  long dayDifferenceCalculator(String createdAt) {

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

	
	/*
	 * dont need while using database public String createdAt(String output, int
	 * i) {
	 * 
	 * String createdAt = ""; JSONArray jArray;
	 * 
	 * try { jArray = new JSONArray(output);
	 * 
	 * JSONObject jsonObj = jArray.getJSONObject(i);
	 * 
	 * createdAt = (String) jsonObj.get("created_at");
	 * 
	 * } catch (JSONException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return createdAt; }
	 */
}
