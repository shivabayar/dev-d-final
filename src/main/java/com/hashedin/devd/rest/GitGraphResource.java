package com.hashedin.devd.rest;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.devd.repository.GitCommitTrendGraphRepository;

/**
 * The Class GitGraphResource.
 */
@Component
@Path("/gitcommittrendgraph")
public class GitGraphResource {

	/** The git commit trend graph repository. */
	@Autowired
	private GitCommitTrendGraphRepository gitCommitTrendGraphRepository;

	/**
	 * List all.
	 *
	 * @param userName the user name
	 * @return the string
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Path("/{userName}")
	public final String listAll(@PathParam("userName")
	final String userName) {
		// Handles GET on /alerts. Lists all the alerts we have in our
		// system.
//		System.out.println(gitCommitTrendGraphRepository
//				.collectCommitGraph(userName));
		return gitCommitTrendGraphRepository
				.collectCommitGraph(userName);
	}
}