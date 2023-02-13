package javaWebEE.hr;
 
import javax.naming.Context;               // https://docs.oracle.com/javase/7/docs/api/javax/naming/Context.html
import javax.naming.InitialContext;        // https://docs.oracle.com/javase/7/docs/api/javax/naming/InitialContext.html
import javax.transaction.UserTransaction;  
import javax.ejb.Stateless;                
import javax.persistence.PersistenceContext;

//Component-defining annotation for a stateless session bean, since EJB 3.0
@Stateless
public class HRService {
	
	@PersistenceContext(unitName = "HRApp-PU")
	private EntityManager entityManager;
	
	public Employee findEmployee(String badgeId) {
		return entityManager.find(Employee.class, badgeId);
	}
	
	public void updateEmployee(Employee emp) {
		Context ctx = new InitialContext();
		UserTransaction userTransaction = ctx.lookup("java:comp/UserTransaction");
		userTransaction.begin();
		entityManager.merge(emp);
		userTransaction.commit();
	}	
}
