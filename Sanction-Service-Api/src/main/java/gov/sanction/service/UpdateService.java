package gov.sanction.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import gov.sanction.entity.AssignmentTypeEntity;
import gov.sanction.repo.AssignmentTypeRepo;




@ApplicationScoped
public class UpdateService 
{

	@Inject
	private AssignmentTypeRepo repo;
	
		public AssignmentTypeEntity createService(AssignmentTypeEntity request) {
			
			AssignmentTypeEntity rs = repo.saveEntity(request);
			
			return rs;
		}
}