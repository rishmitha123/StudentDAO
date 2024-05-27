package com.codegnan.app;

import java.sql.SQLException;

import com.codegnan.beans.Student;
import com.codegnan.dao.StudentDao;

public class DemoApp_01 {

	public static void main(String[] args) {
		Student student1 = new Student(102, "pardhu", "pardhu@gmail.com", "ECE");
		Student student2 = new Student(103, "anju", "anju@gmail.com", "CIVIL");
		Student student3 = new Student(104, "vaishu", "vaishu@gmail.com", "Mech");
		Student student4 = new Student(105, "krithika", "krithika@gmail.com", "CSE");
		Student student5 = new Student(106, "prabha", "prabha@gmail.com", "EEE");
		StudentDao studentDao = new StudentDao();
		try {
			if (studentDao.save(student5)) {

				studentDao.commit();
				System.out.println("student saved successfully");

			} else {
				studentDao.rollback();
				System.out.println("not saved successfully");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
