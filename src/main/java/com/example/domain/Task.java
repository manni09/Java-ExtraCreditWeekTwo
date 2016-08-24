package com.example.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.DATE)
	private Date start_date;
	
	@Temporal(TemporalType.DATE)
	private Date end_date;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ElementCollection
	private List<String> resource;
	
	@ElementCollection
	private List<String> beneficiaries;

	@ManyToMany
	@ElementCollection
	List<User> users;
	
	@ManyToOne
	private Project project;
	
	public Task(){}

	public int getId() {
		return id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public Status getStatus() {
		return status;
	}

	public List<String> getResource() {
		return resource;
	}

	public List<String> getBeneficiaries() {
		return beneficiaries;
	}

	public List<User> getusers() {
		return users;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setResource(List<String> resource) {
		this.resource = resource;
	}

	public void setBeneficiaries(List<String> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public void setusers(List<User> users) {
		this.users = users;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", status=" + status
				+ ", resource=" + resource + ", beneficiaries=" + beneficiaries + ", users=" + users
				+ ", project=" + project + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficiaries == null) ? 0 : beneficiaries.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + id;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (beneficiaries == null) {
			if (other.beneficiaries != null)
				return false;
		} else if (!beneficiaries.equals(other.beneficiaries))
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (id != other.id)
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (status != other.status)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	
}
