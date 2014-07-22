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
@Table(name = "gitModel")
@NamedQueries({
		@NamedQuery(name = "GitModel.findAll", query = "SELECT u FROM GitModel u"),
		@NamedQuery(name = "GitModel.find", query = "Select u from GitModel u where userName =:username"),
		@NamedQuery(name = "GitModel.delete", query = "DELETE FROM GitModel m WHERE m.userName =:username") })
public class GitModel {

	@Id
	@GeneratedValue
	private long userId;
	private long gitUserId;
	private String userGitUrl;
	private boolean pullAction;
	private String createdAt;
	private String eventType;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setPullAction(boolean pullAction) {
		this.pullAction = pullAction;
	}

	public long getGitUserId() {
		return gitUserId;
	}

	public void setGitUserId(long gitUserId) {
		this.gitUserId = gitUserId;
	}

	public String getUserGitUrl() {
		return userGitUrl;
	}

	public void setUserGitUrl(String userGitUrl) {
		this.userGitUrl = userGitUrl;
	}

	public boolean getPullAction() {
		return pullAction;
	}

	public void setPullAction(Boolean merged) {
		this.pullAction = merged;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "GitModel [gitUserId=" + gitUserId + ", userGitUrl="
				+ userGitUrl + ", pullAction=" + pullAction + ", createdAt="
				+ createdAt + ", eventType=" + eventType + "]";
	}

}
