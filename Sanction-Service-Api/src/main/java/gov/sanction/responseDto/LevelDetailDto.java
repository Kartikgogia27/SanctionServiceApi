package gov.sanction.responseDto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class LevelDetailDto {

	private BigDecimal levelTypeId;

	private String levelType;

	private String inchargeRoleID;
}
