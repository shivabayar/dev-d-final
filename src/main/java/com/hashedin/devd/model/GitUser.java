package com.hashedin.devd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

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
	private long userId; // user id for dev-d database
	private String apiKey; // api key saved by us for accessing private repos
	private String gitUserName; // git user name to redirect user to his repo
	private String password; // password taken by dev-d

	@XmlInverseReference(mappedBy = "gitUser")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gitUser", targetEntity = GitPush.class)
	private List<GitPush> gitPush;

	@XmlInverseReference(mappedBy = "gitUser")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "gitUser", targetEntity = GitPull.class)
	private List<GitPull> gitPull;


	public List<GitPush> getGitPush() {
		return gitPush;
	}

	public void setGitPush(List<GitPush> gitPush) {
		this.gitPush = gitPush;
	}

	public List<GitPull> getGitPull() {
		return gitPull;

	}

	public void setGitPull(List<GitPull> gitPull) {
		this.gitPull = gitPull;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;

	}

	public String getGitUsername() {
		return gitUserName;
	}

	public void setGitUsername(String gitUsername) {
		this.gitUserName = gitUsername;
	}

	public String getGitUserName() {
		return gitUserName;
	}

	public void setGitUserName(String gitUserName) {
		this.gitUserName = gitUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

