package gov.sanction.repo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gov.sanction.exception.IFMSException;
import gov.sanction.request.UserDetailRequest;
import gov.sanction.response.UserDetailResponse;


@Dependent
public class UserDetailRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public List<UserDetailResponse> getList( UserDetailRequest request) throws IFMSException{
		
		List<UserDetailResponse> l=new ArrayList<>();
		
		try {
			
			
			 Query query = entityManager.createNativeQuery( "SELECT  a.USER_ID,b.SSOID,b.DISPLAYNAME FROM SSO.MST_USER a "
			 		+ "LEFT JOIN SSO.USERS_DTL_SSO b ON b.SSOID=a.SSO_ID WHERE a.USER_ID  in (:data)");
			query.setParameter("data",request.getUserId());
			
			List<Object[]> authors = query.getResultList();
			for (Object[] a : authors) {
				UserDetailResponse sr=new UserDetailResponse();
				sr.setUserId((String.valueOf(a[0])));
				sr.setSsoId((String)a[1]);
				sr.setDisplayName((String)a[2]);

				l.add(sr);
			}
			
			return l;
		} catch (Exception e) {
			final String mes = "Something went Wrong";
			throw new IFMSException(mes);
		}
		
		
	}

}
