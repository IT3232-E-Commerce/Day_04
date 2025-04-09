package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {
	List<Student> students = new ArrayList<>();
		
	public AppController(){
		students.add(new Student("2021ICT01", "Alice Wonderland", 22, "IT", 3.5));
        students.add(new Student("2021ICT02", "Charlie Chaplin", 24, "IT", 3.1));
        students.add(new Student("2021ICT03", "David Beckham", 23, "IT", 3.4));
        students.add(new Student("2021ICT04", "Emma Watson", 22, "IT", 3.6));
        students.add(new Student("2021ICT05", "Frank Sinatra", 25, "IT", 3.0));
	}
	
	@GetMapping("/home")
    public String homeMessage() {
        return "Welcome to Student Managemant System!";
    }
    
    @GetMapping("/student")
    public Student getStudent() {
        return students.get(0);
    }
    
    @GetMapping("/students")
    public List<Student> getStudents() {    	
    	return students;
    }
    
    @GetMapping("/students/{id}")
    public Student findStudents(@PathVariable("id") String regNo) {
    	for (Student student : students) {
    		if (student.getRegNo().equals(regNo)) {
    			return student;
    		}
    	}
    	return null;
    } 
    
    @GetMapping("/students/age/{min}/{max}")
    public List<Student> findStudentsByAge(@PathVariable int min, @PathVariable int max) {
    	List<Student> filteredStudents = new ArrayList<>();
    	
    	for (Student student : students) {
    		if (student.getAge() > min && student.getAge() < max) {
    			filteredStudents.add(student);
    		}
    	}
    	return filteredStudents;
    }  
    
    @GetMapping("/students/sort")
    public List<Student> getSortedStudents() {
    	List<Student> sortedStudents = new ArrayList<>(students);
    	
    	for (int i = 0; i < students.size(); i++) {
    		for (int j = i + 1; j < students.size(); j++) {
    			if(students.get(i).getGpa() < students.get(j).getGpa()) {
    				Student tempStudent = sortedStudents.get(i);
        			sortedStudents.set(i, sortedStudents.get(j));
        			sortedStudents.set(j, tempStudent);
    			}
    		}
    	}
    	return sortedStudents;
    }
    
    @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully!";
    }   
    
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") String regNo, @RequestBody Student updatedStudent) {
        for (Student student : students) {
        	if (student.getRegNo().equals(regNo)) {
        		student.setName(updatedStudent.getName());
        		student.setAge(updatedStudent.getAge());
        		student.setCourse(updatedStudent.getCourse());
        		student.setGpa(updatedStudent.getGpa());
        		return "Student updated successfully!";
        	}
        }
        return "Student not found!";
    } 
    
    @DeleteMapping("/students/{id}") 
    public String deleteStudent(@PathVariable("id") String regNo) {
        for (Student student : students) {
        	if (student.getRegNo().equals(regNo)) {
        		students.remove(student);
        		return "Student deleted successfully!";
        	}
        }
        return "Student not found!";
    }
}
