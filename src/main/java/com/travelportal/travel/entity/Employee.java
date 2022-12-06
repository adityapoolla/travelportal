package com.travelportal.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee", schema = "travel_portal")
@JsonPropertyOrder({"id","firstName","lastName","email","address","linkedIn","mobileNumber","created_time"})
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	@JsonProperty(value = "id")
	private Long id;

	@Column(name = "first_name")
	@JsonProperty(value = "firstName")
	private String firstName;

	@Column(name = "last_name")
	@JsonProperty(value = "lastName")
	private String lastName;
	

	@Column(name = "email")
	@JsonProperty(value = "email")
	private String email;

	@Column(name = "address")
	@JsonProperty(value = "address")
	private String address;

	//@Column(name = "linkedIn")
	@Column(name = "linked_In")
	@JsonProperty(value = "linkedIn")
	private String linkedIn;

	@Column(name = "mobile_number")
	@JsonProperty(value = "mobileNumber")
	private String mobileNumber;
    
	@Column(name = "created_time")
	@JsonProperty(value = "created_time")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date created_time;


}
