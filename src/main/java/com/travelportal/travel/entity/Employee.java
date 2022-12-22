package com.travelportal.travel.entity;

//import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee", schema = "travel_portal")
@JsonPropertyOrder({ "id", "firstName", "lastName", "email", "address", "linkedIn", "mobileNumber", "created_time" })
public class Employee {

	/**
	 * 
	 */
	// ōprivate static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", linkedIn=" + linkedIn + ", mobileNumber=" + mobileNumber
				+ ", created_time=" + created_time + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	@JsonProperty(value = "id")
	private Long id;

	@Column(name = "first_name")
	@JsonProperty(value = "firstName")
	public String firstName;

	@Column(name = "last_name")
	@JsonProperty(value = "lastName")
	private String lastName;

	@Getter
	@Setter
//	@Column(name = "email")
	@JsonProperty(value = "email")
	public String email;

	@Getter
	@Setter
	// @Column(name="password")
	@JsonProperty(value = "password")
	public String password;

	@Column(name = "address")
	@JsonProperty(value = "address")
	private String address;

	@Column(name = "linked_In")
	@JsonProperty(value = "linkedIn")
	private String linkedIn;

	@Column(name = "mobile_number")
	@JsonProperty(value = "mobileNumber")
	private String mobileNumber;

	@Column(name = "created_time")
	@JsonProperty(value = "created_time")
	private Date created_time;

	@PrePersist
	void preInsert() {
		if (this.created_time == null) {
			this.created_time = new Date();
		}
	}
	
	
	

}
