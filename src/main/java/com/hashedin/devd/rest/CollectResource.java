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

@Component
@Path("/collects")
public class CollectResource {

	@Autowired
	private CollectRepository collectRepository;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<GitModel> listAll() {
		return collectRepository.listAll();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{userName}")
	public void find(@PathParam("userName") String userName) {
		collectRepository.collect(userName);
	}
}
