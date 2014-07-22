package com.hashedin.devd.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.devd.model.GitPull;
import com.hashedin.devd.model.GitPush;
import com.hashedin.devd.model.GitUser;
import com.hashedin.devd.realdata.GitApiReader;
import com.hashedin.devd.service.GitPullService;
import com.hashedin.devd.service.GitPushService;
import com.hashedin.devd.service.GitUserService;

//@Required
@Component
@Path("/user")
public class GitUserResource {
	@Autowired
	private GitUserService gitUserService;

	@Autowired
	private GitPullService gitPullService;

	@Autowired
	private GitPushService gitPushService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<GitUser> listAll() {
		// Handles GET on /user. Lists all the users we have in our
		// system.
		return gitUserService.findAll();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(GitUser user,
			@Context final HttpServletResponse response)
			throws URISyntaxException, IOException, JSONException {
		// Handles POST on /user. Creates a new user and adds it into an
		// repository.
		gitUserService.save(user);
		GitApiReader gar = new GitApiReader();
		List<GitPull> gitPullList = null;
		List<GitPush> gitPushList = null;

		gar.parseAndSaveCommitsAndPullRequestsToDB(user.getGitUserName());
		gitPullList = gar.getGitPullList();
		gitPushList = gar.getGitPushList();

		if (gitPullList != null) {
			gitPullService.save(gitPullList);
		}

		if (gitPushList != null) {
			gitPushService.save(gitPushList);
		}

		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/user/" + user.getUserId())).build();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{userId}/{userName}/{password}/{apikey}")
	public GitUser update(@PathParam("userId") Long gitUserId,
			@PathParam("userName") String userName,
			@PathParam("password") String password,
			@PathParam("apikey") String apikey) throws IOException,
			JSONException {

		GitUser gitUser = gitUserService.find(gitUserId);
		gitUser.setApiKey(apikey);
		gitUser.setGitUserName(userName);
		gitUser.setPassword(password);
		return gitUser;
	}

}
