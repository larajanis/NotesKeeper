package com.psna.digilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psna.digilearn.model.Course;
import com.psna.digilearn.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> findCourses(int semester, String department) {
		return courseRepository.findBySemesterAndDepartment(semester, department);
	}

	@Override
	public List<Course> findCoursesForStaff(String facultyName) {
		return courseRepository.findByFacultyName(facultyName);
	}
	
	@Override
	public Course findCourse(int id) {
		return courseRepository.findById(id);
	}

}
