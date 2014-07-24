package com.hashedin.devd.service;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.Alert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class AlertServiceTest extends TestCase {

	@Autowired
	private AlertService service;

	@Test
	public void testAlerts() {
		List<Alert> alerts = service.findAll();
		assertEquals(alerts.size(), 0);
		Alert alert = new Alert();
		alert.setBrokeBuild(false);
		alert.setFrequentCommits(true);
		alert.setGitPullrequestId(0);
		alert.setGitUserId(123);
		alert.setIsFrequentCommits(true);
		alert.setLastCommitedAt(1);
		alert.setUserName("MasroorHamdani");
		service.save(alert, alert.getUserName());
		alerts = service.findAll();
		assertEquals(alerts.size(), 1);

		alerts = service.find("MasroorHamdani");
		assertEquals(alerts.size(), 1);

		alert = new Alert();
		alert.setBrokeBuild(false);
		alert.setFrequentCommits(true);
		alert.setGitPullrequestId(0);
		alert.setGitUserId(123);
		alert.setIsFrequentCommits(true);
		alert.setLastCommitedAt(1);
		alert.setUserName("MasroorHamdani");
		service.save(alert, alert.getUserName());
		alerts = service.find("MasroorHamdani");
		assertEquals(alerts.size(), 1);
	}
}
