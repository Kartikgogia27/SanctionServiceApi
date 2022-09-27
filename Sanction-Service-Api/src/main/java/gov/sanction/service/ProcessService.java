package gov.sanction.service;

import java.util.List;

import gov.sanction.exception.IFMSException;
import gov.sanction.responseDto.ProcessResponseDto;

public interface ProcessService {

	
	public List<ProcessResponseDto> getProcess(int id) throws IFMSException;
	
	
	
}
