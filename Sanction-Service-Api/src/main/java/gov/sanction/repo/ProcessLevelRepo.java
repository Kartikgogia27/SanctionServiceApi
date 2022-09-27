package gov.sanction.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gov.sanction.exception.IFMSException;
import gov.sanction.response.ProcessResponse;
import gov.sanction.responseDto.ProcessResponseDto;
import gov.sanction.responseDto.ProcessDetailDto;

@ApplicationScoped
public class ProcessLevelRepo {

	@PersistenceContext
	private EntityManager entityManager;

	public List<ProcessResponseDto> getAllProcessLevel(int id) throws IFMSException{
		List<ProcessResponseDto> processResponseDtoList=new ArrayList<>();
		try {
		
		Query query = entityManager.createNativeQuery("SELECT pp.LEVEL_TYPE_ID,"
				+ "pp.LEVEL_TYPE,pp.INCHARGE_ROLE_ID,pc.process_task_id,ph.TASK_ROLE_NAME FROM MST_WF_PROCESS_LEVEL p "
				+ "LEFT JOIN MST_WF_PROCESS_LEVEL_TYPE pp on p.LEVEL_TYPE_ID=pp.LEVEL_TYPE_ID "
				+ "LEFT JOIN MST_WF_PROCESS_TASK_CONFIG pc on pc.PROCESS_LEVEL_ID=p.PROCESS_LEVEL_ID "
				+ "LEFT JOIN MST_WF_TASK_ROLE_MASTER ph on pc.ROLE_ID=ph.TASK_ROLE_ID "
				+ "where p.PROCESS_ID= :processId");
		query.setParameter("processId", id);

		List<Object[]> taskResponseList = (List<Object[]>) query.getResultList();
		System.out.println(taskResponseList.size());
		for (Object[] taskResponse : taskResponseList) {
			List<ProcessDetailDto> taskDetailDto=new ArrayList<>();
			ProcessResponse processResponse = new ProcessResponse();
			processResponse.setLevelTypeId((BigDecimal) taskResponse[0]);
			processResponse.setLevelType((String) taskResponse[1]);
			processResponse.setInchargeRoleID(String.valueOf(taskResponse[2]));
			processResponse.setTaskId((BigDecimal) taskResponse[3]);
			processResponse.setTaskRoleName((String) taskResponse[4]);
			
			ProcessResponseDto processResponseDto=new ProcessResponseDto();
			
			processResponseDto.setLevelType(processResponse.getLevelType());
			processResponseDto.setLevelTypeId(processResponse.getLevelTypeId());
			processResponseDto.setInchargeRoleID(processResponse.getInchargeRoleID());
			
			ProcessDetailDto taskDto=new ProcessDetailDto();
			taskDto.setTaskId(processResponse.getTaskId());
			taskDto.setTaskRoleName(processResponse.getTaskRoleName());
			taskDetailDto.add(taskDto);
			processResponseDto.setTaskdetails(taskDetailDto);
			processResponseDtoList.add(processResponseDto);
		}
		
		}catch (Exception e) {
			final String mes = "Something went Wrong";
			throw new IFMSException(mes);
		}

		

		return processResponseDtoList;

	}

}
