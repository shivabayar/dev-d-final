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

import com.hashedin.devd.model.GitPush;

import com.hashedin.devd.service.GitPushService;

@Component
@Path("/gitpush")
public class GitPushResource {

	@Autowired
	private GitPushService gitPushService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<GitPush> listAll() {
		// Handles GET on /user. Lists all the users we have in our
		// system.
		return gitPushService.findAll();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(GitPush gitPush,
			@Context final HttpServletResponse response)
			throws URISyntaxException {
		// Handles POST on /user. Creates a new user and adds it into an
		// repository.
		gitPushService.save(gitPush);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/gitPush/" + gitPush.getId())).build();
	}

}
