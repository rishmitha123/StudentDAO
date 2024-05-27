package com.codegnan.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.codegnan.beans.Student;
import com.codegnan.dao.StudentDao;
import com.codegnan.exception.InvalidStudentIdException;

public class DemoApp_02 {

	public static void main(String[] args){
		StudentDao studentDao = new StudentDao();
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter ID of the student you want to modify :");
			int id = sc.nextInt();
			Student student = studentDao.findById(id);
			System.out.println("ID : "+student.getId());
			System.out.println("Name : "+student.getName());
			System.out.println("Email : "+student.getEmail());
			System.out.println("Branch : "+student.getBranch());
			
			System.out.println("Enter new values to the student : ");
			System.out.print("Name : ");
			String name = sc.next();
			System.out.print("Email : ");
			String email = sc.next();
			System.out.println("Branch : ");
			String branch = sc.next();
			student.setName(name);
			student.setEmail(email);
			student.setBranch(branch);
			if(studentDao.edit(student)) {
				studentDao.commit();
				System.out.println("Student modified successfully");
			}
			else {
				System.out.println("FAiled to modify the student");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidStudentIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}