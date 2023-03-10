package javaWebEE.hr.service;
 
import javax.naming.Context;               // https://docs.oracle.com/javase/7/docs/api/javax/naming/Context.html
import javax.naming.InitialContext;        // https://docs.oracle.com/javase/7/docs/api/javax/naming/InitialContext.html
import javax.naming.NamingException;
import javax.transaction.UserTransaction;
import javaWebEE.hr.entity.EntityManager;
import javaWebEE.hr.model.Employee;
import javax.ejb.Stateless;                
import javax.persistence.PersistenceContext;

// Component-defining annotation for a stateless session bean, since EJB 3.0
@Stateless
public class HRService {
	
	@PersistenceContext(unitName = "HRApp-PU")
	private EntityManager entityManager;
	
	public Employee findEmployee(String badgeId) {
		return entityManager.find(new Employee(), badgeId);
	}
	
	public void updateEmployee(Employee emp) throws Exception {
		Context ctx = new InitialContext();
		UserTransaction userTransaction = (UserTransaction)ctx.lookup("java:comp/UserTransaction");
		userTransaction.begin();
		entityManager.merge(emp);
		userTransaction.commit();
	}	
}
