package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDTO;
import com.app.entities.Student;
import com.app.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("in ctor of" + getClass());
	}

	// REST API to add student details
	// URL: http://host:port/students, method=POST
	// request payload: StudentDTO(no ID)
	// response: success--SC 201,StudentDTO(with ID)
	// response: err--SC 500,ApiResp DTO
	@PostMapping
	public ResponseEntity<?> addNewStudent(@RequestBody StudentDTO dto) {
		System.out.println("in addNewStudent" + dto);
		try {
			// response: success--SC 201,StudentDTO(with ID)
			return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudentDetails(dto));
		} catch (RuntimeException e) {
			System.out.println("err" + e);
			// response: err--SC 500,ApiResp DTO
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new com.app.dto.ApiResponse(e.getMessage()));
		}
	}

	// REST API to get all student details
	// URL: http://host:port/students/all method=GET
	@GetMapping("/all")
	public List<Student> allStudents() {
		return studentService.getAllStudents();
	}
}
