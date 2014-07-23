package com.hashedin.devd.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.devd.model.GitPull;
import com.hashedin.devd.service.GitPullService;

@Component
@Path("/gitpull")
public class GitPullResource {

	@Autowired
	private GitPullService gitPullService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<GitPull> listAll() {
		// Handles GET on /user. Lists all the users we have in our
		// system.
		return gitPullService.findAll();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(GitPull gitPull,
			@Context final HttpServletResponse response)
			throws URISyntaxException {
		// Handles POST on /user. Creates a new user and adds it into an
		// repository.
		gitPullService.save(gitPull);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/gitpull/" + gitPull.getId())).build();
	}

}
