 package com.hashedin.devd.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.devd.model.Alert;
import com.hashedin.devd.model.GitModel;
import com.hashedin.devd.repository.CollectRepository;


//import com.hashedin.devd.service.CollectService;

@Component
@Path("/collects")
public class CollectResource {

	@Autowired
	private CollectRepository collectRepository;
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void listAll() {
		// Handles GET on /alerts. Lists all the alerts we have in our
		// system.
		//collectRepository.collect();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{userName}")

/*	public void find(@PathParam("userId") Long userId){
		
	}
//	@POST
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Response create(Alert alert,
//			@Context final HttpServletResponse response)
//			throws URISyntaxException {
//		// Handles POST on /alerts. Creates a new alert and adds it into an
//		// repository.
//		collectService.save(alert);
//		response.setStatus(Response.Status.CREATED.getStatusCode());
//		return Response.created(new URI("/collects/" + alert.getAlertId()))
//				.build();
//	}
}
*/
	public  void find(@PathParam("userName") String userName){
		collectRepository.collect(userName);
		//return collectRepository.find(userId);
		//return null;
	}
}

