package com.psna.digilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psna.digilearn.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findBySemesterAndDepartment(int semester, String department);
	List<Course> findByFacultyName(String facultyName);
	Course findById(int id);
}
