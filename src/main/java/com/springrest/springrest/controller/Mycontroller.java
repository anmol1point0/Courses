package com.springrest.springrest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.Services;

@RestController
public class Mycontroller {

	@Autowired
	private Services myService;

	@GetMapping("/courses")
	public List<Course> getvalue() {
		return myService.getCourses();
	}

	@GetMapping("/courses/{courseId}")
	public Course getOneCourse(@PathVariable String courseId) throws NullPointerException {
		try {
			return myService.getOneCourse(Integer.parseInt(courseId));
		} catch (NullPointerException e) {
			throw new NullPointerException("No course found");
		}
	}

	@PostMapping("/courses")
	public ResponseEntity addOneCourse(@RequestBody Course course) {
		try {
			System.out.println("inside controller");
			myService.addNewCourse(course);
			System.out.println("New course added successfully");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/courses/{courseId}")
	public ResponseEntity updateCourse(@RequestBody Course course) {
		try {
			myService.UpdateCourse(course);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("courses/{courseId}")
	public ResponseEntity deleteCourse(@PathVariable Integer courseId) {
		try {
			myService.DeleteCourse(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
