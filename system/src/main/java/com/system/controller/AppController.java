package com.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.model.Course;
import com.system.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {
	Student Bob = new Student("No.1", "Bob Marley", 23, "IT", 3.2);
	Student James = new Student("No.2", "James Bond", 24, "IT", 2.2);
	Student Donald = new Student("No.3", "Donald Trump", 25, "IT", 1.2);

	Course IT = new Course("IT", "Information Technology");
	Course AMC = new Course("AMC", "Advanced Mathematics Computing");

	private static List<Student> students = new ArrayList<Student>();
	private Map<String, Student> mstudents = new HashMap<String, Student>();

	private static List<Course> courses = new ArrayList<Course>();
	private Map<String, Course> mcourses = new HashMap<String, Course>();
}
