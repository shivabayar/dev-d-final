package com.hashedin.devd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class GitModel.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
@XmlRootElement
@Entity
@Table(name = "gitModel")
@NamedQueries({
@NamedQuery(name = "GitModel.findAll", query = "SELECT u FROM GitModel u"),
@NamedQuery(name = "GitModel.find",
query = "Select u from GitModel u where u.userName =:username"),
@NamedQuery(name = "GitModel.delete",
query = "DELETE FROM GitModel m WHERE m.userName =:username") })
public class GitModel {

	/**
	 * Description of the variable here.
	 */
	@Id
	@GeneratedValue
	private long userId;
	/**
	 * Description of the variable here.
	 */
	private long gitUserId;
	/**
	 * Description of the variable here.
	 */
	private String userGitUrl;
	/**
	 * Description of the variable here.
	 */
	private boolean pullAction;
	/**
	 * Description of the variable here.
	 */
	private String createdAt;
	/**
	 * Description of the variable here.
	 */
	private String eventType;
	/**
	 * Description of the variable here.
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
	 * @return Description text text text.
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
	 * @return Description text text text.
	 */
	public final long getUserId() {
		return userId;
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
	 * @param userId the new user id
	 */
	public final void setUserId(final long userId) {
		this.userId = userId;
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
	 * @param pullAction the new pull action
	 */
	public final void setPullAction(final boolean pullAction) {
		this.pullAction = pullAction;
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
	public final long getGitUserId() {
		return gitUserId;
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
	public final String getUserGitUrl() {
		return userGitUrl;
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
	 * @param userGitUrl the new user git url
	 */
	public final void setUserGitUrl(final String userGitUrl) {
		this.userGitUrl = userGitUrl;
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
	public final boolean getPullAction() {
		return pullAction;
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
	 * @param merged the new pull action
	 */
	public final void setPullAction(final Boolean merged) {
		this.pullAction = merged;
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
	public final String getCreatedAt() {
		return createdAt;
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
	 * @param createdAt the new created at
	 */
	public final void setCreatedAt(final String createdAt) {
		this.createdAt = createdAt;
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
	public final String getEventType() {
		return eventType;
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
	 * @param eventType the new event type
	 */
	public final void setEventType(final String eventType) {
		this.eventType = eventType;
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
		return "GitModel [gitUserId=" + gitUserId + ", userGitUrl="
				+ userGitUrl + ", pullAction=" + pullAction
				+ ","
				+ " createdAt=" + createdAt
				+ ", eventType=" + eventType + "]";
	}

}
