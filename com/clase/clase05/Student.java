package com.clase.clase05;

public class Student {
	private String name, surname, email, documentNumber;
	private int age;
	private double qualification;
	private Course course;
	
	public Student(
		String name,
		String surname,
		String email,
		String dni,
		Course course,
		int age,
		double nota
	) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.documentNumber = dni;
		this.age = age;
		this.qualification = nota;
		this.course = course;
	}
	
	public Student(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getQualification() {
		return qualification;
	}

	public void setQualification(double qualification) {
		this.qualification = qualification;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String toString() {
		try {
			return
					"Alumno [nombre=" + this.name + ", apellido=" + this.surname
							+ ", email=" + this.email + ", dni=" + this.documentNumber + ", edad="
							+ this.age + ", nota=" + this.qualification + ", curso=" + course.toString() + "]";
		}catch (Exception e) {
			System.out.println("Hay un error con " + this.name + " " + this.surname);
		}
		return "";
	}
	
}

