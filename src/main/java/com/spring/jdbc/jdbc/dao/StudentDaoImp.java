package com.spring.jdbc.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.jdbc.modell.Student;

public class StudentDaoImp implements StudentDao {
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// insert query
		String query = "insert into student (id, name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public int modify(Student student) {
        String query = "UPDATE student SET name = ?, city = ? WHERE id = ?";
        return jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
    }

	public List<Student> getAllStudents() {
	    String query = "SELECT * FROM student";
	    return jdbcTemplate.query(query, (rs, rowNum) -> {
	        Student student = new Student();
	        student.setId(rs.getInt("id"));
	        student.setName(rs.getString("name"));
	        student.setCity(rs.getString("city"));
	        return student;
	    });
	}
	
//	public List<Student> getAllStudents() {
//	    String query = "SELECT * FROM student";
//	    List<Student> students = jdbcTemplate.query(query, new StudentRowMapper());
//	    return students;
//	}
//
//	private static class StudentRowMapper implements RowMapper<Student> {
//	    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//	        Student student = new Student();
//	        student.setId(rs.getInt("id"));
//	        student.setName(rs.getString("name"));
//	        student.setCity(rs.getString("city"));
//	        return student;
//	    }
//	}
	
	public Student getStudentById(int id) {
	    String query = "SELECT * FROM student WHERE id = ?";
	    return jdbcTemplate.queryForObject(query, new Object[] { id }, (rs, rowNum) -> {
	        Student student = new Student();
	        student.setId(rs.getInt("id"));
	        student.setName(rs.getString("name"));
	        student.setCity(rs.getString("city"));
	        return student;
	    });
	}

	public int delete(int id) {
		String query = "DELETE FROM student WHERE id = ?";
		return jdbcTemplate.update(query, id);
	}

}
