package gov.sanction.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gov.sanction.exception.IFMSException;
import gov.sanction.response.TaskAssignResponse;
import gov.sanction.responseDto.TaskAssignResponseDto;
import gov.sanction.responseDto.TaskDetailsDto;
@ApplicationScoped
public class TaskRepo {
	
	

		@PersistenceContext
		private EntityManager entityManager;

		public List<TaskAssignResponseDto> getAllTask(int id) throws IFMSException{
			List<TaskAssignResponseDto> processResponseDtoList=new ArrayList<>();
			try {
			
			Query query = entityManager.createNativeQuery(" SELECT pp.LEVEL_TYPE_ID, "
					+ "pp.LEVEL_TYPE,pp.INCHARGE_ROLE_ID,pc.process_task_id,ph.TASK_ROLE_NAME,pt.PARENT_ASSIGNMENT_ID FROM MST_WF_PROCESS_LEVEL p "
					+ "LEFT JOIN MST_WF_PROCESS_LEVEL_TYPE pp on p.LEVEL_TYPE_ID=pp.LEVEL_TYPE_ID "
					+ "LEFT JOIN MST_WF_PROCESS_TASK_CONFIG pc on pc.PROCESS_LEVEL_ID=p.PROCESS_LEVEL_ID "
					+ "LEFT JOIN MST_WF_ASSIGNMENT_TYPE pa on p.PROCESS_ID=pa.PROCESS_ID "
					+ "LEFT JOIN MST_WF_TASK_ROLE_MASTER ph on pc.ROLE_ID=ph.TASK_ROLE_ID "
					+ "LEFT JOIN MST_WF_TASK_ASSIGNMENT pt on pt.PROCESS_TASK_ID=pc.PROCESS_TASK_ID "
					+ "where p.PROCESS_ID= :processId");
			query.setParameter("processId", id);
			List<Object[]> taskResponseList = (List<Object[]>) query.getResultList();
		
			
			for (Object[] taskResponse : taskResponseList) {
				List<TaskDetailsDto> taskDetailDto=new ArrayList<>();
				TaskAssignResponse taskAssignResponse = new TaskAssignResponse();
				
				taskAssignResponse.setLevelTypeId((BigDecimal) taskResponse[0]);
				taskAssignResponse.setLevelType((String) taskResponse[1]);
				taskAssignResponse.setInchargeRoleID(String.valueOf(taskResponse[2]));
				taskAssignResponse.setTaskId((BigDecimal) taskResponse[3]);
				taskAssignResponse.setTaskRoleName((String) taskResponse[4]);
				taskAssignResponse.setAssignedBy((BigDecimal)taskResponse[5]) ;
				
				TaskAssignResponseDto processResponseDto=new TaskAssignResponseDto();
				
				processResponseDto.setLevelType(taskAssignResponse.getLevelType());
				processResponseDto.setLevelTypeId(taskAssignResponse.getLevelTypeId());
				processResponseDto.setInchargeRoleID(taskAssignResponse.getInchargeRoleID());
			
				
				TaskDetailsDto taskDto=new TaskDetailsDto();
				taskDto.setTaskId(taskAssignResponse.getTaskId());
				taskDto.setTaskRoleName(taskAssignResponse.getTaskRoleName());
				taskDto.setAssignedBy(taskAssignResponse.getAssignedBy());
				taskDetailDto.add(taskDto);
				processResponseDto.setTaskdetails(taskDetailDto);
				processResponseDtoList.add(processResponseDto);
			}
			return processResponseDtoList;
			}catch (Exception e) {
				final String mes = "Something went Wrong";
				throw new IFMSException(mes);
			}

		
	}
}