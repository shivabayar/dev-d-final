package com.hashedin.devd.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@XmlRootElement
@Entity
@Table(name = "gitUsers")
@NamedQueries({ @NamedQuery(name = "GitUser.findAll", query = "SELECT u FROM GitUser u") })
public class GitUser {

	@Id
	@GeneratedValue
	private long userId; // owner of the repo
	private long gitUserId;
	private String email;
	private String apiKey;
	private String userProfileUrl;
	private String password;

	public long getuserId() {
		return userId;
	}
	
	public long getGitUserId() {
		return gitUserId;
	}

	public void setGitUserId(long gitUserId) {
		this.gitUserId = gitUserId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserProfileUrl() {
		return userProfileUrl;
	}

	public void setUserProfileUrl(String userProfileUrl) {
		this.userProfileUrl = userProfileUrl;
	}

	public long getUserId() {
		return gitUserId;
	}

	public void setUserId(long gitUserId) {
		this.gitUserId = gitUserId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

}
