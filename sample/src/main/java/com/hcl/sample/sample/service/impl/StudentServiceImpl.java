package com.hcl.sample.sample.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.sample.sample.entity.Student;
import com.hcl.sample.sample.repository.StudentRepository;
import com.hcl.sample.sample.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public Student save(Student student) {
		return repository.save(student);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Student> getStudentList() {
		return repository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public List<Student> saveStudentList(List<Student> studentsList) {
		return repository.saveAll(studentsList);
	}

}
