package com.hashedin.devd.alert;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class AlertFilterTest extends TestCase {

	AlertsImpl al = new AlertsImpl();
	AlertFilter al2 = new AlertFilter();

	@Test
	public void testAlerts() {
		Alert a = new Alert();

		GitModel gitModel = new GitModel();
		GitModel gitModel1 = new GitModel();
		GitModel gitModel3 = new GitModel();
		List<GitModel> l = new ArrayList<GitModel>();
		List<String> l2 = new ArrayList<String>();

		gitModel.setEventType("PushEvent");
		gitModel1.setEventType("PushEvent");
		gitModel3.setEventType("PullRequestEvent");
		gitModel.setCreatedAt("2014-07-22T07:24:29Z");
		gitModel1.setCreatedAt("2014-07-20T07:24:29Z");
		gitModel.setGitUserId(1);
		gitModel1.setGitUserId(1);
		gitModel3.setGitUserId(1);
		gitModel.setUserName("pavankumar77");
		gitModel1.setUserName("pavankumar77");
		gitModel3.setUserName("pavankumar77");

		l2.add("2014-07-21T07:24:29Z");
		l2.add("2014-07-10T07:24:29Z");
		l2.add("2014-07-19T07:24:29Z");

		l.add(gitModel);
		l.add(gitModel1);
		l.add(gitModel3);
<<<<<<< HEAD

		// assertEquals(l.size(), 3);

=======
>>>>>>> 63d2567cbc2a4c2a5b6db0702e09a89c81c89f65
		boolean i = al.isFrequentComits(l2);
		assertEquals(al.lastCommitedAt(gitModel.getCreatedAt()), 2);
		assertEquals(i, false);

		a.setAlertId(0);
		a.setFrequentCommits(false);
		a.setLastCommitedAt(1);
		a.setUrl(null);
		a.setBrokeBuild(false);
		a.setGitUserId(1);
		a.setUserName("pavankumar77");
		a.setGitPullrequestId(1);
<<<<<<< HEAD
	
		assertEquals(al2.createFilter(l).getAlertId(), 0);
	//	System.out.println(a);
=======
		assertEquals(al2.createFilter(l).getAlertId(), 0);
>>>>>>> 63d2567cbc2a4c2a5b6db0702e09a89c81c89f65
	//	assertEquals(al2.createFilter(l), a);

	}
}