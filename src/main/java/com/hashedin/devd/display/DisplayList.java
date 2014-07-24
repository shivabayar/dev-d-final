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

/**
 *  @param gitModel
 *            (3)
 * @return Description text text text.
 */
	public final String displayCommitTrendGraphFilter(
			final List<GitModel> gitModel) {

		return display.frequencyCalculator(createList(
				gitModel, "PushEvent"));
	}

	/**
	 * @param gitModel
	 *            (3)
	 * @return Description text text text.
	 */
	public final String displayPullGraphFilter(final
			List<GitModel> gitModel) {

		return display.frequencyCalculator(createList(gitModel,
				"PullRequestEvent"));
	}

	/**
	 * @param gitModel,
	 * @param event           (3)
	 * @return createdAtList
	 */
	public final List<String> createList(final List<GitModel> gitModel,
			final String event) {
		List<String> createdAtList = new ArrayList<String>();
		boolean isNull = false;
		try {
			for (GitModel model : gitModel) {
				String s = model.getEventType();
				if (s.endsWith(event)
						&& (isNull == s.equals(null))) {
					createdAtList.add(model.getCreatedAt());
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return createdAtList;
	}
}