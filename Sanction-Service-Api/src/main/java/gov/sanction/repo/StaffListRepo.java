package gov.sanction.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gov.sanction.exception.IFMSException;
import gov.sanction.request.StaffListRequest;
import gov.sanction.response.StaffListResponse;

@Dependent
public class StaffListRepo {

	@PersistenceContext
	private EntityManager entityManager;

	public List<StaffListResponse> getlist(StaffListRequest request) throws IFMSException{

		List<StaffListResponse> l = new ArrayList<>();
		try {
		if (request.getFlag().equalsIgnoreCase("S")) {

			Query qlQuery = entityManager
					.createNativeQuery("SELECT  b.SSOID,b.DISPLAYNAME,a.USER_ID FROM SSO.MST_USER a "
							+ "LEFT JOIN SSO.USERS_DTL_SSO b ON b.SSOID=a.SSO_ID WHERE a.USER_ID  in (:data)");
			qlQuery.setParameter("data", request.getAssignmentId());
			List<Object[]> authors = qlQuery.getResultList();
			for (Object[] a : authors) {
				StaffListResponse sr = new StaffListResponse();

				sr.setSsoId((String) a[0]);
				sr.setDisplayName((String) a[1]);
				sr.setUserId((String) a[2]);
				l.add(sr);
			}
			return l;
		} else if (request.getFlag().equalsIgnoreCase("C")) {

			Query qlQuery = entityManager
					.createNativeQuery(" SELECT  b.SSOID,b.DISPLAYNAME,ab.USER_ID FROM SSO.MST_USER a "
							+ " LEFT JOIN SSO.USERS_DTL_SSO b ON b.SSOID=a.SSO_ID "
							+ "  LEFT JOIN SSO.DTL_USER_ASSIGNMENT ab on  ab.USER_ID=a.USER_ID "
							+ "  JOIN   SSO.DTL_USER_ASSIGNMENT  az  ON "
							+ "  ab.ASSIGNMENT_TYPE_ID = az.PARENT_ID   WHERE a.USER_ID  in (:data) ");
			qlQuery.setParameter("data", request.getUserId());
			List<Object[]> authors = qlQuery.getResultList();
			for (Object[] a : authors) {
				StaffListResponse sr = new StaffListResponse();
				sr.setSsoId((String) a[0]);
				sr.setDisplayName((String) a[1]);
				sr.setUserId((String) a[2]);
				l.add(sr);
			}
			return l;
		} else {
			return l;
		}

		}catch (Exception e) {
			final String mes = "Something went Wrong";
			throw new IFMSException(mes);
		}
	}
}