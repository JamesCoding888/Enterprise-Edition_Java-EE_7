package javaWebEE.hr2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private String badgeId;
	private String name;

	public Employee() {
		// empty constructor required by JPA
	}

	public Employee(String badgeId, String name) {
		this.badgeId = badgeId;
		this.name = name;
	}

	// getters and setters
	public String getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(String badgeId) {
		this.badgeId = badgeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}