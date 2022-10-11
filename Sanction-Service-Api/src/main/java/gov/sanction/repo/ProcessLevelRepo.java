package gov.sanction.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gov.sanction.exception.IFMSException;
import gov.sanction.response.ProcessResponse;
import gov.sanction.responseDto.LevelDetailDto;
import gov.sanction.responseDto.ProcessDetailDto;
import gov.sanction.responseDto.ProcessResponseDto;

@ApplicationScoped
public class ProcessLevelRepo {

	@PersistenceContext
	private EntityManager entityManager;

	public List<ProcessResponseDto> getAllProcessLevel(int id) throws IFMSException{
		
		List<ProcessResponseDto> processResponseDtoList=new ArrayList<>();
		Map<LevelDetailDto, List<ProcessDetailDto>> map1 = new HashMap<>();
		ProcessResponseDto d=new ProcessResponseDto();
		List<ProcessResponseDto> data=new ArrayList<>();
		try {
		
		Query query = entityManager.createNativeQuery("SELECT pp.LEVEL_TYPE_ID,"
				+ "pp.LEVEL_TYPE,pp.INCHARGE_ROLE_ID,pc.process_task_id,ph.TASK_ROLE_NAME FROM MST_WF_PROCESS_LEVEL p "
				+ "LEFT JOIN MST_WF_PROCESS_LEVEL_TYPE pp on p.LEVEL_TYPE_ID=pp.LEVEL_TYPE_ID "
				+ "LEFT JOIN MST_WF_PROCESS_TASK_CONFIG pc on pc.PROCESS_LEVEL_ID=p.PROCESS_LEVEL_ID "
				+ "LEFT JOIN MST_WF_TASK_ROLE_MASTER ph on pc.ROLE_ID=ph.TASK_ROLE_ID "
				+ "where p.PROCESS_ID= :processId");
		query.setParameter("processId", id);
		ProcessResponse processResponse = new ProcessResponse();
		List<Object[]> taskResponseList = (List<Object[]>) query.getResultList();
		for (Object[] taskResponse : taskResponseList) {
			
			ProcessResponseDto processResponseDto=new ProcessResponseDto();
			List<ProcessDetailDto> taskDetailDto=new ArrayList<>();
			
			processResponse.setLevelTypeId((BigDecimal) taskResponse[0]);
			processResponse.setLevelType((String) taskResponse[1]);
			
			processResponse.setInchargeRoleID(String.valueOf(taskResponse[2]));
		processResponseDto.setLevelType(processResponse.getLevelType());
		processResponseDto.setLevelTypeId(processResponse.getLevelTypeId());
		processResponseDto.setInchargeRoleID(processResponse.getInchargeRoleID());
		
		processResponse.setTaskId((BigDecimal) taskResponse[3]);
		processResponse.setTaskRoleName((String) taskResponse[4]);
		
			ProcessDetailDto taskDto=new ProcessDetailDto();
			taskDto.setTaskId(processResponse.getTaskId());
			taskDto.setTaskRoleName(processResponse.getTaskRoleName());
			
			taskDetailDto.add(taskDto);
			processResponseDto.setTaskdetails(taskDetailDto);
			processResponseDtoList.add(processResponseDto);
			
			
		}
		
		String prevLevelType = "";
		
		 
		List<ProcessDetailDto> list=null;
		for (ProcessResponseDto p : processResponseDtoList) {
			if (!p.getLevelType().equals(prevLevelType)) {
				 list = new ArrayList<ProcessDetailDto>();
				list.add(p.getTaskdetails().get(0));
				LevelDetailDto levelDetailDto = new LevelDetailDto();
				levelDetailDto.setInchargeRoleID(p.getInchargeRoleID());
				levelDetailDto.setLevelType(p.getLevelType());
				levelDetailDto.setLevelTypeId(p.getLevelTypeId());
				map1.put(levelDetailDto, list);
				prevLevelType = p.getLevelType();
				
			}else {
				LevelDetailDto Success = new LevelDetailDto();
				Success.setInchargeRoleID(p.getInchargeRoleID());
				Success.setLevelType(p.getLevelType());
				Success.setLevelTypeId(p.getLevelTypeId());
				
				map1.get(Success).add(p.getTaskdetails().get(0));
				
			}
			 
		}
		
		List<ProcessDetailDto> processDetailDto=new ArrayList<>();
		
		for(Map.Entry m : map1.entrySet()){    
			ProcessResponseDto c=new ProcessResponseDto();
			LevelDetailDto la = (LevelDetailDto) m.getKey();
			c.setInchargeRoleID(la.getInchargeRoleID());
			c.setLevelType(la.getLevelType());
			c.setLevelTypeId(la.getLevelTypeId());
			processDetailDto =  (List<ProcessDetailDto>) m.getValue();
			
			c.setTaskdetails(processDetailDto);
			data.add(c);
	}
		
		System.out.println(data);
		
		


		}catch (Exception e) {
			final String mes = "Something went Wrong";
			throw new IFMSException(mes);
		}

		

		return data;

	}

}
