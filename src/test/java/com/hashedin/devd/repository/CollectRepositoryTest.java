package com.hashedin.devd.repository;

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

import com.hashedin.devd.model.GitModel;

// TODO: Auto-generated Javadoc
/**
 * The Class CollectRepositoryTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class CollectRepositoryTest extends TestCase {

	/** The collect repository. */
	@Autowired
	private CollectRepository collectRepository;

	/**
	 * Test.
	 */
	@Test
	public void test() {

		GitModel gitModel = new GitModel();
		GitModel gitModel1 = new GitModel();
		GitModel gitModel3 = new GitModel();
		List<GitModel> l = new ArrayList<GitModel>();
		List<GitModel> l1 = new ArrayList<GitModel>();
		List<String> l2 = new ArrayList<String>();

		gitModel.setEventType("PushEvent");
		gitModel1.setEventType("PushEvent");
		gitModel3.setEventType("PullRequestEvent");
		gitModel.setCreatedAt("2014-07-22T07:24:29Z");
		gitModel1.setCreatedAt("2014-07-20T07:24:29Z");
		gitModel3.setCreatedAt("2014-07-20T07:24:29Z");
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

		collectRepository.save(l, "pavankumar77");

		l1 = collectRepository.find("pavankumar77");

		assertEquals(l1.get(0).getCreatedAt(), l.get(0).getCreatedAt());

	}

}