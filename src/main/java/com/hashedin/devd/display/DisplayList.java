package com.hashedin.devd.display;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.hashedin.devd.model.GitModel;

/**
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
public class DisplayList {

/**
* Description of the variable here.
*/
	@Autowired
	private DisplayImpl display = new DisplayImpl();

	public String displayCommitTrendGraphFilter(List<GitModel> gitModel) {

		return display.frequencyCalculator(createList(gitModel, "PushEvent"));
	}

	public String displayPullGraphFilter(List<GitModel> gitModel) {

		return display.frequencyCalculator(createList(gitModel,
				"PullRequestEvent"));
	}

	public List<String> createList(List<GitModel> gitModel, String event) {
		List<String> createdAtList = new ArrayList<String>();
		boolean isNull = false;
		try {
			for (GitModel model : gitModel) {
				String s = model.getEventType();
				if (s.endsWith(event) && (isNull == s.equals(null))) {
					createdAtList.add(model.getCreatedAt());
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return createdAtList;
	}
}