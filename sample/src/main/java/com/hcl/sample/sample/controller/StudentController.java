package com.hcl.sample.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.sample.sample.entity.Student;
import com.hcl.sample.sample.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Student student) {
		Student response = studentService.save(student);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student) {
		Student response = studentService.save(student);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		studentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getList() {
		List<Student> response = studentService.getStudentList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Integer studentId) {
		Student response = null;
		Optional<Student> student = studentService.getStudentById(studentId);
		if (student.isPresent()) {
			response = student.get();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/createList")
	public ResponseEntity<?> saveSudentList(@RequestBody List<Student> studentsList) {
		List<Student> studentList = studentService.saveStudentList(studentsList);

		return new ResponseEntity<>(studentList, HttpStatus.CREATED);
	}

}
