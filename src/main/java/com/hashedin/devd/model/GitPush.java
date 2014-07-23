package com.hashedin.devd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "gitPush")
@NamedQueries({ @NamedQuery(name = "GitPush.findAll", query = "SELECT g FROM GitPush g") })
public class GitPush {

	@Id
	@GeneratedValue
	private long id;
	private String commitMessage;
	private String committedDate;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private GitUser gitUser;

	public GitUser getGitUser() {
		return gitUser;
	}

	public void setGitUser(GitUser gitUser) {
		this.gitUser = gitUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommitMessage() {
		return commitMessage;
	}

	public void setCommitMessage(String commitMessage) {
		this.commitMessage = commitMessage;
	}

	public String getCommittedDate() {
		return committedDate;
	}

	public void setCommittedDate(String committedDate) {
		this.committedDate = committedDate;
	}

}
