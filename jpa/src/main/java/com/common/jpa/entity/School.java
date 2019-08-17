package com.common.jpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School {
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

	@Id
	private Integer id;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	private String name;


	@OneToMany(mappedBy = "schoolId", cascade =  CascadeType.ALL , fetch = FetchType.EAGER)
	@JsonProperty("students")
	private List<Student> students = new ArrayList<>();

}
