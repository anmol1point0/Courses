package com.springrest.springrest.service;

import java.util.*;

import com.springrest.springrest.entities.Course;

public interface Services {
	public List<Course> getCourses();

	public Course getOneCourse(Integer courseid);

	public Course addNewCourse(Course course);

	public Course UpdateCourse(Course course);

	public void DeleteCourse(Integer courseId);
}
