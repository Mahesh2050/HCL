package com.hcl.sample.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.sample.sample.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
