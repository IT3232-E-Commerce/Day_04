package com.system.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.system.model.*;

@RestController
@RequestMapping("/")
public class AppController {
	Student Bob = new Student("1", "Bob Marley", 23, "IT", 3.2);
	Student James = new Student("2", "James Bond", 24, "IT", 2.2);
	Student Donald = new Student("3", "Donald Trump", 25, "IT", 1.2);

	Course IT = new Course("IT", "Information Technology");
	Course AMC = new Course("AMC", "Advanced Mathematics Computing");

	private Map<String, Student> mstudents = new HashMap<String, Student>();
	private Map<String, Course> mcourses = new HashMap<String, Course>();

	private AppController() {
		mstudents.put(Bob.getRegNo(), Bob);
		mstudents.put(James.getRegNo(), James);
		mstudents.put(Donald.getRegNo(), Donald);

		mcourses.put(IT.getCid(), IT);
		mcourses.put(AMC.getCid(), AMC);
	}

	@GetMapping("students")
	public Map<String, Student> getStudents() {
		return mstudents;
	}

	@GetMapping("students/{id}")
	public Student getStudent(@PathVariable("id") String RegNo) {
		return mstudents.get(RegNo);
	}

	@PostMapping("students")
	public String addStudent(@RequestBody Student student) {
		mstudents.put(student.getRegNo(), student);
		return "Student successfully added";
	}

	@DeleteMapping("students/{id}")
	public String deleteStudent(@PathVariable("id") String RegNo) {
		if (mstudents.get(RegNo) != null) {
			mstudents.remove(RegNo);
			return "Student successfully deleted";
		}
		return "Student not found";
	}

	@PutMapping("students/{id}")
	public String updateStudent(@PathVariable("id") String RegNo, @RequestBody Student student) {
		if (mstudents.get(RegNo) != null) {
			mstudents.put(student.getRegNo(), student);
			return "Student successfully updated";
		}
		return "Student not found";
	}

	@GetMapping("courses")
	public Map<String, Course> getCourses() {
		return mcourses;
	}

	@GetMapping("courses/{id}")
	public Course getCourse(@PathVariable("id") String CourseNo) {
		return mcourses.get(CourseNo);
	}

	@PostMapping("courses")
	public String addCourse(@RequestBody Course course) {
		mcourses.put(course.getCid(), course);
		return "Course successfully added";
	}

	@DeleteMapping("courses/{id}")
	public String deleteCourse(@PathVariable("id") String CourseNo) {
		if (mcourses.get(CourseNo) != null) {
			mcourses.remove(CourseNo);
			return "Course successfully deleted";
		}
		return "Course not found";
	}

	@PutMapping("courses/{id}")
	public String updateCourse(@PathVariable("id") String CourseNo, @RequestBody Course course) {
		if (mcourses.get(CourseNo) != null) {
			mcourses.put(course.getCid(), course);
			return "Course successfully updated";
		}
		return "Course not found";
	}
}
