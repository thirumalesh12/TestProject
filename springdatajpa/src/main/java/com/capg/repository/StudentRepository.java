package com.capg.repository;

import org.springframework.data.repository.CrudRepository;

import com.capg.entites.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
