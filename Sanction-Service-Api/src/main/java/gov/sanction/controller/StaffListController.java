package gov.sanction.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import gov.sanction.entity.ApiResponse;
import gov.sanction.exception.IFMSException;
import gov.sanction.request.StaffListRequest;
import gov.sanction.response.StaffListResponse;
import gov.sanction.service.StaffListService;



@Path("/")
public class StaffListController {

	
	@Inject
	private StaffListService service;

	@POST
	@Path("/getStaffList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(@RequestBody StaffListRequest listRequest)  throws IFMSException
		{
		
		List<StaffListResponse> listofprocess = service.getList(listRequest);
		 return Response.ok(ApiResponse.success(listofprocess)).build();
		
		}
}
