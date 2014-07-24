package com.hashedin.devd.integration;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitModel;
import com.hashedin.devd.realdata.JavaUrlConnectionReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class IntegretionTest extends TestCase {

	CreateGitModelObject createGitModel = new CreateGitModelObject();

	@Autowired
	JavaUrlConnectionReader juc = new JavaUrlConnectionReader();

	@Test
	public void testAlerts() {
		@SuppressWarnings("unused")
		GitModel gitModel = new GitModel();
		final int temp = 19;
		String str = juc.getUrlContents("pavankumar77");
		String urlOutput = str.substring(2, temp);
		String actual = "\"id\":\"2186240306\"";
		GitModel gitModel2 = createGitModel
				.gitModelObject("pavankumar77")
				.get(0);

		assertEquals(urlOutput, actual);
		assertEquals(gitModel2.getGitUserId(), 0);

	}
}