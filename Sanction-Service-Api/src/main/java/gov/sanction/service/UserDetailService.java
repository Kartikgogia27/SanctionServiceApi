package gov.sanction.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import gov.sanction.exception.IFMSException;
import gov.sanction.repo.UserDetailRepo;
import gov.sanction.request.UserDetailRequest;
import gov.sanction.response.UserDetailResponse;


@Dependent
public class UserDetailService {
	
	@Inject
	private UserDetailRepo repo;
	
	public List<UserDetailResponse> getList( UserDetailRequest request) throws IFMSException
	{
		List<UserDetailResponse> ol = repo.getList(request); 
		
		return ol;
	}

}
