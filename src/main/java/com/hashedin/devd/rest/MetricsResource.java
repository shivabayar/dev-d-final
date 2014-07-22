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

import com.hashedin.devd.service.MetricService;
import com.hashedin.devd.model.GitMetric;

@Component
@Path("/metrics")
public class MetricsResource {

	@Autowired
	private MetricService metricService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<GitMetric> listAll() {
		// Handles GET on /metrics. Lists all the metrics we have in our
		// system.
		return metricService.findAll();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(GitMetric metric,
			@Context final HttpServletResponse response)
			throws URISyntaxException {
		// Handles POST on /metrics. Creates a new metrics and adds it into an
		// repository.
		metricService.save(metric);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/metrics/" + metric.getMetricId()))
				.build();
	}
}
