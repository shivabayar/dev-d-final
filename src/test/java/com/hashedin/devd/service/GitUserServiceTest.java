package com.hashedin.devd.service;

import static org.junit.Assert.*;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.devd.model.GitUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class GitUserServiceTest extends TestCase {

	@Autowired 
	private GitUserService service;
	
	@Test
	public void testUsers() {
		List<GitUser> users = service.findAll();
		assertEquals(users.size(), 0);
		
		GitUser gitUser=new GitUser();
		gitUser.setApiKey("123qwe");
		gitUser.setEmail("masroor.h@hashedin.com");
		gitUser.setGitUserId(123);
		gitUser.setGitUsername("MasroorHamdani");
		gitUser.setPassword("hasher123");
		gitUser.setUserProfileUrl("github.com/MasroorHamdani/");
		
		service.save(gitUser);
		users=service.findAll();
		assertEquals(users.size(), 1);
		
		GitUser user = service.find("MasroorHamdani");
		assertEquals(user.getGitUsername(), "MasroorHamdani");
		
	}

}
