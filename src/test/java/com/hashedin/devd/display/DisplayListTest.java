package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class DisplayListTest extends TestCase {

	@Autowired
	private DisplayInterface service;
		
	DisplayList displayList = new DisplayList();
	
	
	@Test
	public void testAlerts() {
			
		GitModel gitModel = new GitModel();
		GitModel gitModel1 = new GitModel();
		List<GitModel> l = new ArrayList<GitModel>();
		gitModel.setEventType("PushEvent");
		gitModel1.setEventType("PushEvent");
		gitModel.setCreatedAt("2014-07-22T07:24:29Z");
		gitModel1.setCreatedAt("2014-07-20T07:24:29Z");
		GitModel gitModel3 = new GitModel();
		gitModel3.setEventType("PullRequestEvent");;
		
		
		l.add(gitModel);
		l.add(gitModel1);
		l.add(gitModel3);
		assertEquals(l.size(), 3);
		
		JSONObject j  =new JSONObject();
		
		
//		j={"two":0,"five":0,"one":1,"three":1,"four":0,"zero":0,"six":0};

	try {
		j.put("two", 0);j.put("two", 0);j.put("two", 0);j.put("two", 0);j.put("two", 0);} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		String str = displayList.displayCommitTrendGraphFilter(l);		
		String str1 = displayList.displayPullGraphFilter(l);		
	//	assertEquals(str, j);
				
		//assertEquals(str,"{"two":0,"five":0,"one":0,"three":0,"four":0,"zero":0,"six":0}"");
		assertNotNull(str1);
		
		
		
		
		
	}
}