package gov.sanction.service;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import gov.sanction.exception.IFMSException;
import gov.sanction.repo.StaffListRepo;
import gov.sanction.request.StaffListRequest;
import gov.sanction.response.StaffListResponse;



@Dependent
public class StaffListService {

	
	@Inject
	private StaffListRepo listRepo;
	
	public List<StaffListResponse> getList( StaffListRequest request)  throws IFMSException{
	
		List<StaffListResponse> o = listRepo.getlist(request); 
		
		return o;
	}
}
