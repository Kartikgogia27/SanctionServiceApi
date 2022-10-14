package gov.sanction.repo;

import java.sql.Timestamp;

import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import gov.sanction.entity.AssignmentTypeEntity;
import gov.sanction.request.AssignmentType;


@ApplicationScoped
public class AssignmentTypeRepo 
{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public AssignmentTypeEntity saveEntity(AssignmentTypeEntity entity) {
	  Timestamp instant= Timestamp.from(Instant.now());  
      AssignmentType newEntity = new AssignmentType();
      entity.setInserted_dt(instant);
		newEntity.setRoleId(entity.getIntrole_id());
		newEntity.setOperFromDate(entity.getOper_from_date());
		newEntity.setInsertedDt(entity.getInserted_dt());
		newEntity.setInsertedIp(entity.getInserted_ip());
		newEntity.setUpdatedDt(instant);
		
		
		 entityManager.persist(newEntity);
		
	return entity;
		
}
}
