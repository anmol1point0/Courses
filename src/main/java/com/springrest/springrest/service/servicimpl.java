package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class servicimpl implements Services {

	@Autowired
	private CourseDao courseDao;

	public servicimpl() {
		// list = new ArrayList<>();
		// list.add(new Course("Book1",1,"Desc of Book1"));
		// list.add(new Course("Book2",2,"Desc of Book2"));
		// list.add(new Course("Book3",3,"Desc of Book3"));
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Course getOneCourse(Integer courseid) throws NullPointerException {
		return courseDao.getOne(courseid);
	}

	@Override
	public Course addNewCourse(Course course) {
		System.out.println("inside service layer");
		// courseDao.save(course);
		courseDao.save(course);
		System.out.println("service completed");
		return course;
	}

	@Override
	public Course UpdateCourse(Course course) {
		return courseDao.save(course);
	}

	@Override
	public void DeleteCourse(Integer courseId) {
		courseDao.delete(courseDao.getOne(courseId));
	}
}
