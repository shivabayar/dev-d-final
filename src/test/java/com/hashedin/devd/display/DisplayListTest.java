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

// TODO: Auto-generated Javadoc
/**
 * The Class DisplayListTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class DisplayListTest extends TestCase {

	/** The service. */
	@Autowired
	private DisplayInterface service;

	/** The display list. */
	DisplayList displayList = new DisplayList();

	/**
	 * Test alerts.
	 */
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
		gitModel3.setEventType("PullRequestEvent");

		l.add(gitModel);
		l.add(gitModel1);
		l.add(gitModel3);
		assertEquals(l.size(), 3);
	}
}