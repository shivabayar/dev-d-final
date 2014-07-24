package com.hashedin.devd.realdata;

import java.net.*;
import java.io.*;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Repository;
/**
 * The Class JavaUrlConnectionReader.
 *
 * @author Hasedin Technologies ltd.
 * @version 1.0
 * @since 24-07-2014
 */
@Service
@Repository
public class JavaUrlConnectionReader {

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param userName the user name
	 * @return content
	 */
	public final String getUrlContents(final String userName) {
		StringBuilder content = new StringBuilder();

		try {
			URL url = new URL("https://api.github.com/users/"
		+ userName + "/events/public");
			URLConnection urlConnection = url.openConnection();

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlConnection
							.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("content "+content.toString());
		return content.toString();
	}
}