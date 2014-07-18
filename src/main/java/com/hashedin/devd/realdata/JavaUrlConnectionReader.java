package com.hashedin.devd.realdata;

import java.net.*;
import java.io.*;

public class JavaUrlConnectionReader {

	public String getUrlContents(String userName) {
		StringBuilder content = new StringBuilder();

		try {
	URL url = new URL("https://api.github.com/users/" + userName+ "/events/public");
			//URL url = new URL(userName);

			URLConnection urlConnection = url.openConnection();

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Output\n\n\n"+content.toString());
		
		return content.toString();
	}
}
