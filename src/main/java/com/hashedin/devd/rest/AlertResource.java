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

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.service.AlertService;

/**
 * The Class AlertResource.
 */
@Component
@Path("/alerts")
public class AlertResource {

	/** The alert service. */
	@Autowired
	private AlertService alertService;

	/**
	 * Creates the.
	 *
	 * @param alert the alert
	 * @param response the response
	 * @param username the username
	 * @return the response
	 * @throws URISyntaxException the URI syntax exception
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{username}")
	public final Response create(final Alert alert,
			@Context final HttpServletResponse response,
			@PathParam("username") final String username)
			throws URISyntaxException {
		// Handles POST on /alerts.
		//Creates a new alert and adds it into an
		// repository.
		alertService.save(alert , username);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/alerts/" + alert
				.getAlertId()))
				.build();
	}

	/**
	 * Find.
	 *
	 * @param username the username
	 * @return the list
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{username}")
	public final List<Alert> find(@PathParam("username")
	final String username) {
		return alertService.find(username);
	}
}
