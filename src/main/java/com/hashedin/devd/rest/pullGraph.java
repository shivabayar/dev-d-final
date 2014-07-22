package com.hashedin.devd.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.devd.repository.GitCommitTrendGraphRepository;

@Component
@Path("/pullGraph")
public class pullGraph {

	@Autowired
	private GitCommitTrendGraphRepository gitCommitTrendGraphRepository;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Path("/{userName}")
	public String listAll(@PathParam("userName") String userName) {
		// Handles GET on /alerts. Lists all the alerts we have in our
		// system.
		return gitCommitTrendGraphRepository.pushCommitGraph(userName);
	}
}