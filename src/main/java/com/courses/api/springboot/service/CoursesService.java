package com.courses.api.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.courses.api.springboot.model.CourseBean;
import com.courses.api.springboot.model.StudentBean;

@Component
public class CoursesService {

	private static List<StudentBean> students = new ArrayList<>();

	static {
		// Initialize Data
		CourseBean course1 = new CourseBean("Course1", "Spring", "10 Steps",
				Arrays.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		CourseBean course2 = new CourseBean("Course2", "Spring MVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));

		StudentBean student = new StudentBean("Student1", "Student Name",
				"Software Engineer", new ArrayList<>(
						Arrays.asList(course1, course2)));

		students.add(student);
	}

	public StudentBean retrieveStudent(String studentId) {
		for (StudentBean student : students) {
			if (student.getId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	public List<CourseBean> retrieveCourses(String studentId) {
		StudentBean student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		return student.getCourses();
	}
}