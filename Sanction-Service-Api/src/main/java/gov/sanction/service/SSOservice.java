package gov.sanction.service;

import java.util.List;

import gov.sanction.exception.IFMSException;
import gov.sanction.request.SSORequest;
import gov.sanction.response.SSOResponse;

public interface SSOservice {

	List<SSOResponse> getSSO(SSORequest request) throws IFMSException;
}
