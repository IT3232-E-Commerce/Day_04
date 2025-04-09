package lk.ac.vau.fas.ict.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import lk.ac.vau.fas.ict.model.*;

@RestController
@RequestMapping("/app")
public class AppController {
	Student Alice = new Student("2021ICT01", "Alice Wonderland", 22, "IT", 3.5);
	Student Charlie = new Student("2021ICT02", "Charlie Chaplin", 24, "IT", 3.1);
    Student David = new Student("2021ICT03", "David Beckham", 23, "IT", 3.4);
    Student Emma = new Student("2021ICT04", "Emma Watson", 22, "IT", 3.6);
    Student Frank = new Student("2021ICT05", "Frank Sinatra", 25, "IT", 3.0);
	
    private Map<String, Student> mstudents = new HashMap<String, Student>();
    
    public AppController() {
    	mstudents.put(Alice.getRegNo(), Alice);
    	mstudents.put(Charlie.getRegNo(), Charlie);
    	mstudents.put(David.getRegNo(), David);
    	mstudents.put(Emma.getRegNo(), Emma);
    	mstudents.put(Frank.getRegNo(), Frank);
    }
    
    @GetMapping("/students")
    public Map<String, Student> getStudents(){
    	return mstudents;
    }
    
    @GetMapping("/student/{id}")
    public Student getStudents(@PathVariable("id") String regNo){
    	return mstudents.get(regNo);
    }
}
