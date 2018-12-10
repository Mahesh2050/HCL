package com.hcl.sample.sample.service;

import java.util.List;
import java.util.Optional;

import com.hcl.sample.sample.entity.Student;

public interface StudentService {

	public Student save(Student student);

	public void delete(int id);

	public List<Student> getStudentList();

	public Optional<Student> getStudentById(Integer id);

	public List<Student> saveStudentList(List<Student> studentsList);
}
