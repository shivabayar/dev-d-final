package com.hashedin.devd.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.devd.model.GitModel;
import com.hashedin.devd.repository.CollectRepository;
/**
 * The Class CollectResource.
 */
@Component
@Path("/collects")
public class CollectResource {

	/** The collect repository. */
	@Autowired
	private CollectRepository collectRepository;

	/**
	 * List all.
	 *
	 * @return the list
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public final List<GitModel> listAll() {
		return collectRepository.listAll();
	}

	/**
	 * Find.
	 *
	 * @param userName the user name
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{userName}")
	public final void find(@PathParam("userName") final String userName) {
		collectRepository.collect(userName);
	}
}
