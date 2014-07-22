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
@Table(name = "gitPull")
@NamedQueries({ @NamedQuery(name = "GitPull.findAll", query = "SELECT g FROM GitPull g") })
public class GitPull {

	@Id
	@GeneratedValue
	private long id;

	private String status; // status of pull request
	private String pulledDate;
	private String url;

	public GitUser getGitUser() {
		return gitUser;
	}

	public void setGitUser(GitUser gitUser) {
		this.gitUser = gitUser;
	}

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private GitUser gitUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPulledDate() {
		return pulledDate;
	}

	public void setPulledDate(String pulledDate) {
		this.pulledDate = pulledDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
