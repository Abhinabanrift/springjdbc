package com.spring.jdbc.jdbc.dao;

import java.util.List;

import com.spring.jdbc.jdbc.modell.Student;

public interface StudentDao {
	public int insert(Student student);
	public int modify(Student st);
	public List<Student> getAllStudents();
	public int delete(int id);
}
