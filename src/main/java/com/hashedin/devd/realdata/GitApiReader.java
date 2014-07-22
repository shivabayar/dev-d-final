package com.hashedin.devd.realdata;

import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hashedin.devd.model.GitPull;
import com.hashedin.devd.model.GitPush;

public class GitApiReader {

	private List<GitPull> gitPullList = new ArrayList<GitPull>();
	private List<GitPush> gitPushList = new ArrayList<GitPush>();

	public List<GitPull> getGitPullList() {
		return gitPullList;
	}

	public void setGitPullList(List<GitPull> gitPullList) {
		this.gitPullList = gitPullList;
	}

	public List<GitPush> getGitPushList() {
		return gitPushList;
	}

	public void setGitPushList(List<GitPush> gitPushList) {
		this.gitPushList = gitPushList;
	}

	private static JSONArray readJsonFromGitApi(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static String parseDate(String date) {

		String ResultString = new String();
		try {
			Pattern regex = Pattern.compile("([0-9]{4})-([0-9]{2})-([0-9]{2})");
			Matcher regexMatcher = regex.matcher(date);
			if (regexMatcher.find() && regex != null) {
				ResultString = regexMatcher.group(0);
				// System.out.println(ResultString);
			} else {
				ResultString = "0";
			}

		} catch (PatternSyntaxException ex) {
			// Syntax error in the regular expression
		}

		return ResultString;
	}

	public void parseAndSaveCommitsAndPullRequestsToDB(String gitUserName)
			throws IOException, JSONException {

		JSONArray eventsJSONArray = readJsonFromGitApi("https://api.github.com/users/tanwanirahul/events");
		List<GitPull> pullList = new ArrayList<GitPull>();
		List<GitPush> pushList = new ArrayList<GitPush>();

		for (int i = 0; i < eventsJSONArray.length(); ++i) {
			JSONObject jsonObj = eventsJSONArray.getJSONObject(i);
			String type = jsonObj.get("type").toString();

			if (type.contains("PushEvent")) {
				// accessing json objects of type pushevents
				GitPush gitPush = new GitPush();
				String createdDate = jsonObj.get("created_at").toString();
				String commitMessage = jsonObj.getJSONObject("payload")
						.getJSONArray("commits").getJSONObject(0)
						.get("message").toString();
				gitPush.setCommittedDate(parseDate(createdDate));
				gitPush.setCommitMessage(commitMessage);
				pushList.add(gitPush);

			} else if (type.contains("PullRequestEvent")) {
				// accessing json objects of type PullRequestEvent
				GitPull gitPull = new GitPull();
				String createdDate = jsonObj.get("created_at").toString();
				String url = jsonObj.getJSONObject("payload")
						.getJSONObject("pull_request").get("html_url")
						.toString();
				gitPull.setPulledDate(parseDate(createdDate));

				gitPull.setUrl(url);
				String status = jsonObj.getJSONObject("payload").get("action")
						.toString();
				gitPull.setStatus(status);
				pullList.add(gitPull);
			}
			setGitPullList(pullList);
			setGitPushList(pushList);
		}
	}
}