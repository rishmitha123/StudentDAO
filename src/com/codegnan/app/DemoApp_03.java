package com.codegnan.app;

import java.sql.SQLException;
import java.util.ArrayList;

import com.codegnan.beans.Student;
import com.codegnan.dao.StudentDao;

public class DemoApp_03 {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		try {
			ArrayList<Student> students = studentDao.findAll();
			for (Student student : students) {
				System.out.println(student);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
