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
import com.hashedin.devd.model.GitUser;
import com.hashedin.devd.service.GitUserService;

//@Required
@Component
@Path("/user")

public class GitUserResource {
	@Autowired
	private GitUserService gitUserService;
	
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
			throws URISyntaxException {
		// Handles POST on /user. Creates a new user and adds it into an
		// repository.
		gitUserService.save(user);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/user/" + user.getUserId()))
				.build();
	}

}
