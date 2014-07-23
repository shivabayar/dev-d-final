<%@ page import="java.util.*" %>
<%@page session="false"%>
<%
	response.addDateHeader("Expires",0); // no caching
	response.addHeader("Pragma","no-cache");
%>
<html>
<body>
  <h1>System Properties</h1>
  <br>
  <table border="1">
  <tr>
	<td><b>Key</b></td>
	<td>&nbsp;</td>
	<td><b>Value</b></td>
  </tr>
  <%
		Properties properties = System.getProperties();
        Enumeration keys = properties.keys();
        String key = null;
        String value = null;
        while(keys.hasMoreElements())
        {
        	key = (String)keys.nextElement();
        	value = System.getProperty(key);
	%>
		<tr>
			<td><%=key%></td>
			<td>&nbsp;</td>
			<td><%=value%></td>
		</tr>
	<%	
		}
        
	%>
  </table>
</body>
</html>
