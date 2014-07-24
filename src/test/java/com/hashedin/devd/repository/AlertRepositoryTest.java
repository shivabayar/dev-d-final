package com.hashedin.devd.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
public class AlertRepositoryTest extends TestCase {

	@Autowired
	private CollectRepository collectRepository;

	@Autowired
	private AlertRepository alertrepo;

	@Test
	public void test() {


		Alert a = new Alert();

		a.setAlertId(0);
		a.setFrequentCommits(false);
		a.setLastCommitedAt(1);
		a.setUrl(null);
		a.setBrokeBuild(false);
		a.setGitUserId(1);
		a.setUserName("pavankumar77");
		a.setGitPullrequestId(1);

		List<Alert> l4 = new ArrayList<Alert>();

		alertrepo.save(a, "pavankumar77");
		l4 = alertrepo.find("pavankumar77");

		assertEquals(l4.get(0).getAlertId(), a.getAlertId());

	}

}