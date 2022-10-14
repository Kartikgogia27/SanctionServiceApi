package gov.sanction.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gov.sanction.exception.IFMSException;
import gov.sanction.request.SSORequest;
import gov.sanction.response.SSOResponse;

@ApplicationScoped
public class SSORepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<SSOResponse> getSSO(SSORequest request) throws IFMSException{
		List<SSOResponse> list = new ArrayList<>();
		
		try {
			Query query= entityManager.createNativeQuery("SELECT  b.SSOID,b.DISPLAYNAME,a.USER_ID FROM SSO.MST_USER a "
					+ "					LEFT JOIN SSO.USERS_DTL_SSO b   ON b.SSOID=a.SSO_ID"
					+ " WHERE b.SSOID LIKE '%"+request.getSsoId()+"% '");
			
		
			List<Object[]> ssoResponseList = (List<Object[]>) query.getResultList();
			for(Object[] ssoResponse:ssoResponseList) {
				
				SSOResponse response = new SSOResponse();
				response.setSsoId((String) ssoResponse[0]);
				response.setEmployeeId((String) ssoResponse[1]);
				response.setUserId((BigDecimal) ssoResponse[2]);
				
				list.add(response);
			}
			
		} catch (Exception e) {
			final String mes = "Something went Wrong";
			System.out.println(e.getMessage());
		}
		
		return list;
	}

}
