package com.psna.digilearn.service;


import java.util.List;

import com.psna.digilearn.model.Course;

public interface CourseService {
	
	 List<Course> findCourses(int semester, String department);
	 
	 List<Course> findCoursesForStaff(String facultyName);
	 
	 Course findCourse(int id);

}
