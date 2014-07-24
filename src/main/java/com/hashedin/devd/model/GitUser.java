package com.hashedin.devd.model;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The Class GitUser.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "gitUsers")
@NamedQueries({
	@NamedQuery(name = "GitUser.findAll", query = "SELECT u FROM GitUser u"),
	@NamedQuery(name = "GitUser.find", query =
	"SELECT u FROM GitUser u where u.email=:email "
			+ "and u.password=:password"),
			@NamedQuery(name = "GitUser.findUser", query = "SELECT u FROM GitUser u where "
					+ "u.gitUserName=:username") })
public class GitUser implements UserDetails {

	/**
	 * Description of the variable here.
	 */
	@Id
	@GeneratedValue
	private long userId; // owner of the repo

	/**
	 * Description of the variable here.
	 */
	private long gitUserId;
	/**
	 * Description of the variable here.
	 */
	private String email;
	/**
	 * Description of the variable here.
	 */
	private String apiKey;
	/**
	 * Description of the variable here.
	 */
	private String userProfileUrl;
	/**
	 * Description of the variable here.
	 */
	private String password;
	/**
	 * Description of the variable here.
	 */
	private String gitUserName;

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return apiKey
	 */
	public final String getApiKey() {
		return apiKey;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return the authorities
	 */
	@SuppressWarnings("deprecation")
	@Override
	public final Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new GrantedAuthorityImpl("ROLE_ADMIN"));
		//return null;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return gitUserId
	 */
	public final long getGitUserId() {
		return gitUserId;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return gitUserName
	 */
	public final String getGitUsername() {
		return gitUserName;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return password
	 */
	@Override
	public final String getPassword() {
		return password;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return userId
	 */
	public final long getUserId() {
		return userId;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return true
	 */
	@Override
	public final String getUsername() {
		return getGitUsername();
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return userProfileUrl
	 */
	public final String getUserProfileUrl() {
		return userProfileUrl;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return true
	 */
	@Override
	public final boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return true
	 */
	@Override
	public final boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return true
	 */
	@Override
	public final boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return true
	 */
	@Override
	public final boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param apiKey the new api key
	 * @return apiKey
	 */
	public final void setApiKey(final String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param email the new email
	 */
	public final void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
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
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param gitUsername the new git username
	 */
	public final void setGitUsername(final String gitUsername) {
		this.gitUserName = gitUsername;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param password the new password
	 */
	public final void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
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
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param userProfileUrl the new user profile url
	 * @return userProfileUrl
	 */
	public final void setUserProfileUrl(final String userProfileUrl) {
		this.userProfileUrl = userProfileUrl;
	}

	/**
	 * Short one line description.   (1)
	 * <p>
	 * Longer description. If there were any, it would be [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @return true
	 */
	@Override
	public final String toString() {
		return "GitUser [userId=" + userId + ", gitUserId=" + gitUserId
				+ ", email=" + email + ", apiKey=" + apiKey
				+ ", userProfileUrl=" + userProfileUrl + ", password="
				+ password + ", gitUsername=" + gitUserName + "]";
	}
}