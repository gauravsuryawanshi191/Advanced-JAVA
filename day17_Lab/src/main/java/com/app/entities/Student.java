package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "dob", callSuper = true)
public class Student extends BaseEntity {
// Rollno, StudentFirstName, StudentLastName, City, CourseName,DoB
	@Column(unique = true, length = 10)
	private String rollNo;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 15)
	private String city;
	@Column(length = 10)
	private String courseName;
	private LocalDate dob;
}
