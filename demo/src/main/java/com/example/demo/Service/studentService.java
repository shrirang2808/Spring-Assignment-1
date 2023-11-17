package com.example.demo.Service;

import java.util.*;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Student;
 
@Component
@Scope("prototype")
 
public class studentService implements InitializingBean, DisposableBean {
 
	private Map<Integer, Student> SM = new HashMap<>();
 
	public void addStudent(Student student) {
		SM.put(student.getId(), student);
		System.out.println("Added student: " + student);
	}
 
	public List<Student> getAllStudents() {
		return new ArrayList<>(SM.values());
	}
 
	public Student getStudentById(int id) {
		Student student = SM.get(id);
		System.out.println(student);
		return student;
	}
 
	public void updateScore(int id, int newScore) {
		if (SM.containsKey(id)) {
			Student student = SM.get(id);
			student.setScore(newScore);
			System.out.println("Updated score for student " + id + ": " + newScore);
			calculateScores(newScore);
		}
	}
 
	public void deleteStudent(int id) {
		if (SM.containsKey(id)) {
			Student removeStudent = SM.remove(id);
			System.out.println("Removed values -" + removeStudent);
		}
	}
 
	public void calculateScores(int score) {
		if (score < 50) {
			System.out.println("Below Average");
		} else if (score > 50 && score < 75) {
			System.out.println("Average");
		} else if (score > 75) {
			System.out.println("Above Average");
		}
	}
 
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Student Service has been initialized.");
	}
 
	@Override
	public void destroy() throws Exception {
		System.out.println("Student Service has been Destroyed.");
	}
 
}