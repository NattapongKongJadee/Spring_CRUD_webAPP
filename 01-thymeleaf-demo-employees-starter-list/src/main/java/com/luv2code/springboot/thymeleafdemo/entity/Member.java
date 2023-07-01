package com.luv2code.springboot.thymeleafdemo.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Entity
@Table(name="member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phonenumber")
	private String phonenumber;

	@Column(name = "remainingtime")
	private Integer remainingtime;

	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	private LocalDate date;

	@Column(name = "expiredate")
	@Temporal(TemporalType.DATE)
	private LocalDate expirationDate;


// define constructors

	public Member() {

	}

	public Member(String firstName, String lastName, String phonenumber, int remainingtime, LocalDate date, LocalDate expirationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonenumber = phonenumber;
		this.remainingtime = remainingtime;
		this.date = date;
		this.expirationDate = expirationDate;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public String getPhonenumber() {

		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {

		this.phonenumber = phonenumber;
	}

	public Integer getRemainingtime() {

		return remainingtime != null ? remainingtime.intValue() : null;
	}

	public void setRemainingtime(int remainingtime) {

		this.remainingtime = remainingtime;
	}

	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Member{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phonenumber='" + phonenumber + '\'' +
				", remainingtime=" + remainingtime +
				", date=" + date +
				", expirationDate=" + expirationDate +
				'}';
	}
}







