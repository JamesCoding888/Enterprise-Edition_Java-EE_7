package javaWebEE.hr.model;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Employee {
	
	private String badge;
	private String name;
	
	/*
		static {
			List<Employee> list = new CopyOnWriteArrayList<>();
			list.add(new Employee("1", "James"));
			list.add(new Employee("2", "David"));
			list.add(new Employee("3", "Marry"));
			
			String badgeId = list.get(0).getBadge();
			String badgeName = list.get(0).getName();
			System.out.println("[" + "badgeId: " + badgeId + " = " + "badgeName: " + badgeName + "]");
			
		}
	*/
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String badge, String name) {
		super();
		this.badge = badge;
		this.name = name;
	}
	
	public String getBadge() {
		return badge;
	}
	
	public void setBadge(String badge) {
		this.badge = badge;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(badge, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(badge, other.badge) && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Employee [badge=" + badge + ", name=" + name + "]";
	}
}
