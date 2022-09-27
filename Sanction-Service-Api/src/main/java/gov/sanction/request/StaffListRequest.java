package gov.sanction.request;

import java.util.List;

import lombok.Data;


@Data
public class StaffListRequest 
{

	List<Integer> assignmentId;
	private String flag;
	List<Integer> userId; 
	
}
