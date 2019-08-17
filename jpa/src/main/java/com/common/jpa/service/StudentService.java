package com.common.jpa.service;

import com.common.jpa.entity.Student;
import com.common.jpa.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		ArrayList results = new ArrayList<Student>();
		studentRepository.findAll().forEach(item->results.add(item));
		return results;
	}

	public Student getStudent(int id) {
		return studentRepository.findById(id).get();
	}

	public Student save(Student s) {
		return studentRepository.save(s);
	}

	public void delete(int id) {
		studentRepository.deleteById(id);
	}
}
