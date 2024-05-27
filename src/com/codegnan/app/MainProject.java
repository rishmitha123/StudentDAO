package com.codegnan.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.codegnan.beans.Student;
import com.codegnan.dao.StudentDao;
import com.codegnan.exception.InvalidStudentIdException;

public class MainProject {

	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. display all students");
			System.out.println("2.display specific student");
			System.out.println("3.add new student");
			System.out.println("4. update");
			System.out.println("5.delete");
			System.out.println("6.exit");
			System.out.println();
			System.out.println("enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
//				System.out.println("displaying all students");

				try {
					StudentDao studentDao = new StudentDao();
					ArrayList<Student> students = studentDao.findAll();

					for (Student student : students) {
						System.out.println(student);
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 2:
//				System.out.println("displaying a specific record");
				System.out.println("enter id to display :");
				int id = sc.nextInt();
				try {
					StudentDao studentDao = new StudentDao();

					Student student = studentDao.findById(id);
					System.out.println(student);
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

				break;
			case 3: {

				try {
					System.out.println("enter id");
					int Id = sc.nextInt();
					System.out.println("enter name :");
					String name = sc.next();
					System.out.println("enter email :");
					String email = sc.next();
					System.out.println("enter branch");
					String branch = sc.next();
					StudentDao studentDao = new StudentDao();
					Student student = new Student(Id, name, email, branch);
					student.setId(Id);
					student.setName(name);
					student.setEmail(email);
					student.setBranch(branch);
					studentDao.save(student);
					studentDao.commit();
					System.out.println("inserted successfully");

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
			case 4: {
				System.out.println("enter id to modify");
				int id1 = sc.nextInt();

				try {
					StudentDao studentDao = new StudentDao();
					Student student = studentDao.findById(id1);
					System.out.println("enter the new values");
					System.out.print("Name : ");
					String name = sc.next();
					System.out.print("Email : ");
					String email = sc.next();
					System.out.println("Branch : ");
					String branch = sc.next();
					student.setName(name);
					student.setEmail(email);
					student.setBranch(branch);
					studentDao.edit(student);
					System.out.println("updated successfully");
					studentDao.commit();

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
				break;
			case 5: {
				try {
					System.out.println("enter id to delete");
					int id2 = sc.nextInt();
					StudentDao studentDao = new StudentDao();
					System.out.println("deleted successfully");
					

					studentDao.delete(id2);
					studentDao.commit();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			break;

			default:
				if (choice != 6) {
					System.out.println("invalid option");
				}
				break;
			}

		} while (choice != 6);
		System.out.println("Thank you!!!");

	}

}
