package com.courses.api.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.courses.api.springboot.model.CourseBean;
import com.courses.api.springboot.service.CoursesService;

@RestController
public class CoursesController {

	@Autowired
	private CoursesService courseService;

	@GetMapping("/students/{studentId}/courses")
	public List<CourseBean> retrieveCoursesForStudent(@PathVariable String studentId) {
		return courseService.retrieveCourses(studentId);
	}
}
