package javaWebEE.hr2;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HRService {
	@PersistenceContext(unitName="HRApp-PU")
	private EntityManager entityManager;
	
	public Employee findEmployee(String badgeId) {
		return entityManager.find(Employee.class, badgeId);
	}

	public void updateEmployee(Employee emp) {
		entityManager.merge(emp);
	}
}