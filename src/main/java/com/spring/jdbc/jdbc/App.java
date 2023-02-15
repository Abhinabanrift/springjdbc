package com.spring.jdbc.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.jdbc.dao.StudentDao;
import com.spring.jdbc.jdbc.modell.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ct = new ClassPathXmlApplicationContext("com/spring/jdbc/jdbc/config.xml");
        StudentDao stDao = ct.getBean("studentDao", StudentDao.class);
        
        Student student = new Student();
        student.setId(203);
        student.setName("abhi");
        student.setCity("kolkata");
        
        int r = stDao.insert(student);
        System.out.println(r);
        
        student.setName("Abhinaba");
        stDao.modify(student);
        
        System.out.println(stDao.getAllStudents());
        System.out.println("\n-----------\n");
        stDao.delete(203);
        System.out.println(stDao.getAllStudents());
    }
}
