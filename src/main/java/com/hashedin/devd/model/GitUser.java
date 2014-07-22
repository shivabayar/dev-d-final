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
@NamedQueries({
		@NamedQuery(name = "GitUser.findAll", query = "SELECT u FROM GitUser u")})
//		@NamedQuery(name = "GitUser.find", query = "SELECT u FROM GitUser u where email=:email "
//				+ "and password=:password"),
//		@NamedQuery(name = "GitUser.findUser", query = "SELECT u FROM GitUser u where "
//				+ "gitUserName=:username") })
public class GitUser {

	@Id
	@GeneratedValue
	private long userId; // owner of the repo

	private long gitUserId;
	private String email;
	private String apiKey;
	private String userProfileUrl;
	private String password;
	private String gitUserName;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGitUserId() {
		return gitUserId;
	}

	public void setGitUserId(long gitUserId) {
		this.gitUserId = gitUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getUserProfileUrl() {
		return userProfileUrl;
	}

	public void setUserProfileUrl(String userProfileUrl) {
		this.userProfileUrl = userProfileUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGitUsername() {
		return gitUserName;
	}

	public void setGitUsername(String gitUsername) {
		this.gitUserName = gitUsername;
	}

	@Override
	public String toString() {
		return "GitUser [userId=" + userId + ", gitUserId=" + gitUserId
				+ ", email=" + email + ", apiKey=" + apiKey
				+ ", userProfileUrl=" + userProfileUrl + ", password="
				+ password + ", gitUsername=" + gitUserName + "]";
	}
}
