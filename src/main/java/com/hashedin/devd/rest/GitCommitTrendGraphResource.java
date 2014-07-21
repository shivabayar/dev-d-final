package com.hashedin.devd.rest;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.devd.repository.GitCommitTrendGraphRepository;

@Component
@Path("/gitcommittrendgraph")
public class GitCommitTrendGraphResource {

	@Autowired
	private GitCommitTrendGraphRepository gitCommitTrendGraphRepository;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Map<String, Integer> listAll() {
			// Handles GET on /alerts. Lists all the alerts we have in our
			// system.
		
			System.out.println("in /gitgraph");
		
			return gitCommitTrendGraphRepository.collectCommitGraph();
	}
}
