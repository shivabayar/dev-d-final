package com.hashedin.devd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class Alert.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
@XmlRootElement
@Entity
@Table(name = "alerts")
@NamedQueries({
@NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a"),
@NamedQuery(name = "Alert.find",
query = "Select u from Alert u where u.userName =:username") })
public class Alert {

	/** The alert id. */
	@Id
	@GeneratedValue
	private long alertId;

	/**
	 * gitPullrequestId.
	 */
	private long gitPullrequestId;
	/**
	 * isBrokeBuild.
	 */
	private boolean isBrokeBuild;
	/**
	 * isFrequentCommits.
	 */
	private boolean isFrequentCommits;
	/**
	 * lastCommitedAt.
	 */
	private int lastCommitedAt;
	/**
	 * url.
	 */
	private String url;
	/**
	 * gitUserId.
	 */
	private long gitUserId;
	/**
	 * userName.
	 */
	private String userName;

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return userName
	 */
	public final String getUserName() {
		return userName;
	}
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param userName the new user name
	 */
	public final void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param isFrequentCommits the new frequent commits
	 */
	public final void setFrequentCommits(final boolean isFrequentCommits) {
		this.isFrequentCommits = isFrequentCommits;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return Description text text text.
	 */
	public final long getAlertId() {
		return alertId;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param alertId the new alert id
	 */
	public final void setAlertId(final long alertId) {
		this.alertId = alertId;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return gitPullrequestId.
	 */
	public final long getGitPullrequestId() {
		return gitPullrequestId;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param gitPullrequestId the new git pullrequest id
	 */
	public final void setGitPullrequestId(final long gitPullrequestId) {
		this.gitPullrequestId = gitPullrequestId;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return true, if is broke build
	 */
	public final boolean isBrokeBuild() {
		return isBrokeBuild;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param isBrokeBuild the new broke build
	 */
	public final void setBrokeBuild(boolean isBrokeBuild) {
		this.isBrokeBuild = isBrokeBuild;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return Description text text text.
	 */
	public final boolean isFrequentCommits() {
		return isFrequentCommits;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param isFrequentCommits the new checks if is frequent commits
	 */
	public final void setIsFrequentCommits(boolean isFrequentCommits) {
		this.isFrequentCommits = isFrequentCommits;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return lastCommitedAt
	 */
	public final int getLastCommitedAt() {
		return lastCommitedAt;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param lastCommitedAt the new last commited at
	 */
	public final void setLastCommitedAt(final int lastCommitedAt) {
		this.lastCommitedAt = lastCommitedAt;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return url.
	 */
	public final String getUrl() {
		return url;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param url the new url
	 */
	public final void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return long
	 */
	public final long getGitUserId() {
		return gitUserId;
	}

	/**
	 * Sets the git user id.
	 *
	 * @param gitUserId the new git user id
	 */
	public final void setGitUserId(final long gitUserId) {
		this.gitUserId = gitUserId;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return Description text text text.
	 */
	@Override
	public final String toString() {
		return "Alert [alertId=" + alertId + ", gitPullrequestId="
				+ gitPullrequestId
				+ ", isBrokeBuild=" + isBrokeBuild
				+ ", isFrequentCommits=" + isFrequentCommits
				+ ", lastCommitedAt="
				+ lastCommitedAt + ", url=" + url
				+ ", gitUserId=" + gitUserId
				+ ", userName=" + userName + "]";
	}
}
