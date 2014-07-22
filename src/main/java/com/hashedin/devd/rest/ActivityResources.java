package com.hashedin.devd.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hashedin.devd.repository.ActivityRepoImpl;

@Repository("ActivityRepo")
@Service
@Component
@Path("/Activity")
public class ActivityResources {

	@Autowired
	ActivityRepoImpl activityRepoImpl = new ActivityRepoImpl();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Path("/{userName}")
	public String listAll(@PathParam("userName") String userName) {

		return activityRepoImpl.activity(userName);
	}
}