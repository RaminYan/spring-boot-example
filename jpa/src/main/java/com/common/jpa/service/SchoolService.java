package com.common.jpa.service;

import com.common.jpa.entity.School;
import com.common.jpa.entity.Student;
import com.common.jpa.repo.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {
	@Autowired
	private SchoolRepository schoolRepository;

	public List<Student> getAllSchools() {
		ArrayList results = new ArrayList<Student>();
		schoolRepository.findAll().forEach(item->results.add(item));
		return results;
	}

	public School getSchool(int id) {
		return schoolRepository.findById(id).get();
	}

	public School save(School s) {
		return schoolRepository.save(s);
	}

	public void delete(int id) {
		schoolRepository.deleteById(id);
	}
}
