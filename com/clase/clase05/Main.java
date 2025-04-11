package com.clase.clase05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner lector;
	private static ArrayList <Course> courseList;
	private static ArrayList <Student> studentList;
	
	public static void main(String[] args) {
		courseList = importCourses();

		for (Course c : courseList) {
			System.out.println(c.toString());
		}

		studentList = leerAlumnos();

		for (Student a : studentList) {
			System.out.println(a.toString());
		}

		for (Student a : studentList) {
			System.out.println(
				"Alumno: " + a.getName() + " " + a.getSurname() + " - Aula: " + a.getCourse().getClassRoom()
			);
		}
	}
	
	private static ArrayList<Student> leerAlumnos() {
		File studentFile = new File("com/clase/clase05/alumnos.csv");
		ArrayList <Student> studentList = new ArrayList <>();
		Student student;
		String[]studentElements;
		String studentString;

		try {
			lector = new Scanner(studentFile);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no es accesible: " + studentFile.getName());
		}
		
		while (lector.hasNext()){
			studentString= lector.nextLine();
			studentElements = studentString.split(",");
			student =
				new Student(
					studentElements[0],
					studentElements[1],
					studentElements[2],
					studentElements[3],
					getStudentList(studentElements[4]),
					Integer.parseInt(studentElements[5].trim().replaceAll("\\uFEFF", "")),
					Double.parseDouble(studentElements[6].trim().replaceAll("\\uFEFF", ""))
				);
			studentList.add(student);
		}
		return studentList;
	}
	
	private static Course getStudentList(String idCourse) {
		for (Course course : courseList) {
			if (course.getIdCourse() == Integer.parseInt(idCourse.trim().replaceAll("\\uFEFF", ""))) {
				return course;
			}
		}
		return null;		
	}
	
	private static ArrayList<Course> importCourses() {
		File courseFile = new File("com/clase/clase05/cursos.csv");
		ArrayList <Course> courseList = new ArrayList <>();
		Course course;
		String[] courseElements;
		String courseString;

		try {
			lector = new Scanner(courseFile);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no es accesible: " + courseFile.getName());
		}
		try {
			while (lector.hasNext()) {
				courseString = lector.nextLine();
				courseElements = courseString.split(",");
				course =
					new Course(
						Integer.parseInt(courseElements[0].trim().replaceAll("\\uFEFF", "")),
						courseElements[1],
						courseElements[2]
					);
				courseList.add(course);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return courseList;
	}
}
