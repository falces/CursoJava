package com.clase.clase05;

public class Course {
	private int idCourse;
	private String name;
	private String classRoom;

	public Course(
		int idCourse,
		String name,
		String classRoom
	){
		this.idCourse = idCourse;
		this.name =name;
		this.classRoom = classRoom;
	}

	public Course() {}

	public int getIdCourse(){
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String toString() {
		return "Curso [id: " + this.idCourse + ", nombre: " + this.name + ", aula: " + this.classRoom + "]";
	}
}
