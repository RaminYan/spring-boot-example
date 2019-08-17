package com.common.jpa.controller;

import com.common.jpa.entity.School;
import com.common.jpa.entity.Student;
import com.common.jpa.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Student> findAll() {
		return schoolService.getAllSchools();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public School find(@PathVariable int id) {
		return schoolService.getSchool(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public School save(@RequestBody School s) {
		return schoolService.save(s);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		schoolService.delete(id);
	}

}
