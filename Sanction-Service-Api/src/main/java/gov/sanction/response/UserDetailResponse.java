package gov.sanction.response;

import lombok.Data;

@Data
public class UserDetailResponse {
	
	private String userId;
	private String ssoId;
	private String displayName; 

}
