package com.common.jpa.controller;

import com.common.jpa.entity.Student;
import com.common.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Student> findAll() {
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student find(@PathVariable int id) {
		return studentService.getStudent(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Student save(@RequestBody Student s) {
		return studentService.save(s);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		studentService.delete(id);
	}

}
