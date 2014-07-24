package com.hashedin.devd.rest;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.devd.model.GitUser;
import com.hashedin.devd.service.GitUserService;

//@Required
/**
 * The Class GitUserResource.
 */
@Component
@Path("/user")
public class GitUserResource {

	/** The git user service. */
	@Autowired
	private GitUserService gitUserService;

	/**
	 * List all.
	 *
	 * @return the list
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public final List<GitUser> listAll() {
		// Handles GET on /user. Lists all the users we have in our
		// system.
		return gitUserService.findAll();
	}

	/**
	 * Find.
	 *
	 * @param username the username
	 * @return the git user
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{username}")
	public final GitUser find(@PathParam("username")
	final String username) {
		// Handles GET on /user. Lists all the users we have in our
		// system.
		return gitUserService.find(username);
	}

	/**
	 * Creates the.
	 *
	 * @param user the user
	 * @param response the response
	 * @return the response
	 * @throws URISyntaxException the URI syntax exception
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public final Response create(final GitUser user,
			@Context final HttpServletResponse response)
			throws URISyntaxException {
		// Handles POST on /user. Creates a new user and adds it into an
		// repository.
		gitUserService.save(user);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response
			.created(new URI("/user/" + user.getUserId())).build();
	}

}