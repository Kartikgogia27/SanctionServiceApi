package gov.sanction.serviceImpl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import gov.sanction.exception.IFMSException;
import gov.sanction.repo.SSORepo;
import gov.sanction.request.SSORequest;
import gov.sanction.response.SSOResponse;
import gov.sanction.service.SSOservice;

@ApplicationScoped
public class SSOServiceImpl  implements SSOservice{
	
	@Inject
	private SSORepo repo;

	@Override
	public List<SSOResponse> getSSO(SSORequest request) throws IFMSException {
		try {
			List<SSOResponse> responses = repo.getSSO(request);
			return responses;
		} catch (Exception e) {
			final String mes = "Something went Wrong";
			throw new IFMSException(mes);
		}
		
	}

}
