package javaWebEE.hr;

import javax.naming.Context;
import javax.naming.InitialContext; // https://docs.oracle.com/javase/7/docs/api/javax/naming/InitialContext.html
import javax.transaction.UserTransaction;

public class HRService {
	
	private EntityManager entityManager;
	
	public Employee findEmployee(String badgeId) {
		return entityManager.find(Employee.class, badgeId);
	}
	
	public void updateEmployee(Employee emp) {
		Context ctx = new InitialContext();
		UserTransaction userTransaction = ctx.lookup("java:comp/UserTransaction");
		userTransaction.begin();
		entityManager.merge(null);
		userTransaction.commit();
	}	
}
