package com.common.jpa.entity;

import javax.persistence.*;

@Entity
public class Student {

	public enum GENDER {
		MALE, FEMAIL;
	}

	@GeneratedValue(strategy= GenerationType.AUTO)
	@Id
	private Integer id;

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	private String name;

	@Enumerated(value = EnumType.STRING)
	private GENDER gender;

	private Integer age;

//	@ManyToOne
//	@JoinColumn(name="school_Id")
	@Column(name="school_Id")
	private Integer schoolId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
