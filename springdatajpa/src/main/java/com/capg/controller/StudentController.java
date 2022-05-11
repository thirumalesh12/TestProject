package com.capg.controller;

import java.util.List;

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

import com.capg.entites.Student;
import com.capg.exceptions.RecordNotFoundException;
import com.capg.repository.StudentRepository;








@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@PostMapping("/create-student")
	// @RequestMapping(value="create-student",method="POST")
	public ResponseEntity<Student> createStudent( @RequestBody Student stu) {
		Student student = repository.save(stu);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}

	@GetMapping("/student-list")
	// @RequestMapping(value="create-student",method="POST")
	public List<Student> getAllStudents() {
		return (List<Student>) repository.findAll();
	}

	@GetMapping("/student-list/{stid}")
	public ResponseEntity<Student> getStudentById(@PathVariable int stid) throws RecordNotFoundException {
		if(repository.findById(stid).isPresent()) {
		Student student = repository.findById(stid).get();
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		else
		{
			throw new RecordNotFoundException("Student with Id: " + stid + " doesn't exist!!");
		}
		
	}

	@PutMapping("/update-student")
	public ResponseEntity<Student> getStudentById(@PathVariable int stid,@RequestBody Student stu) throws RecordNotFoundException {
		if(repository.findById(stid).isPresent()) {
		Student student = repository.findById(stid).get();
		student.setStname(stu.getStname());
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		else
		{
			throw new RecordNotFoundException("Student with Id: " + stid + " doesn't exist!!");
		}
		
	}


	@DeleteMapping("/delete-student/{stid}")
	public void deleteStudentById(@PathVariable int stid) {

		 repository.deleteById(stid);
	}

}



