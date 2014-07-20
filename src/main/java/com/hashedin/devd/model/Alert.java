package com.hashedin.devd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "alerts")

@NamedQueries({ @NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a"),
	@NamedQuery(name = "Alert.find", query = "Select u from Alert u where userName =:username")	
})
//@NamedQuery(name = "Alert.find", query = "SELECT a FROM Alert a where gitUserId=:userid")})

public class Alert {

	@Id
	@GeneratedValue
	private long alertId;
	private long gitPullrequestId;
	private boolean isBrokeBuild;
	private boolean isFrequentCommits;
	private int lastCommitedAt;
	private String url;
	private long gitUserId;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setFrequentCommits(boolean isFrequentCommits) {
		this.isFrequentCommits = isFrequentCommits;
	}
	@SuppressWarnings("unused")
	private boolean FrequentCommits ;
	
	
	public long getAlertId() {
		return alertId;
	}
	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}
	public long getGitPullrequestId() {
		return gitPullrequestId;
	}
	public void setGitPullrequestId(long gitPullrequestId) {
		this.gitPullrequestId = gitPullrequestId;
	}
	public boolean isBrokeBuild() {
		return isBrokeBuild;
	}
	public void setBrokeBuild(boolean isBrokeBuild) {
		this.isBrokeBuild = isBrokeBuild;
	}
	public boolean isFrequentCommits() {
		return isFrequentCommits;
	}
	public void setIsFrequentCommits(boolean isFrequentCommits) {
		this.isFrequentCommits = isFrequentCommits;
	}
	public int getLastCommitedAt() {
		return lastCommitedAt;
	}
	public void setLastCommitedAt(int lastCommitedAt) {
		this.lastCommitedAt = lastCommitedAt;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public long getGitUserId() {
		return gitUserId;
	}
	public void setGitUserId(long gitUserId) {
		this.gitUserId = gitUserId;
	}

}
