package javaWebEE.hr;
import java.util.Objects;

public class Employee {
	
	private String badge;
	private String name;
	
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
