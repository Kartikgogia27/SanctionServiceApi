package gov.sanction.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SSOResponse {
	
	private String ssoId;
	private String employeeId;
	private BigDecimal userId;

}
