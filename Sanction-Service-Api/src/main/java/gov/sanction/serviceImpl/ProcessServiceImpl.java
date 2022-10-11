package gov.sanction.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import gov.sanction.exception.IFMSException;
import gov.sanction.repo.ProcessLevelRepo;
import gov.sanction.responseDto.LevelDetailDto;
import gov.sanction.responseDto.ProcessDetailDto;
import gov.sanction.responseDto.ProcessResponseDto;
import gov.sanction.service.ProcessService;

@ApplicationScoped
public class ProcessServiceImpl implements ProcessService{

	@Inject
	private ProcessLevelRepo  repo;
	
	
	
	@Override
	public List<ProcessResponseDto>  getProcess(int id) throws IFMSException  {
		
		try {
			List<ProcessResponseDto>  data = repo.getAllProcessLevel(id);
		return data;
		}catch (Exception e) {
			final String mes = "Something went Wrong";
			throw new IFMSException(mes);
		}
		
	
		
}

}
