package com.algebra.baze;

public class Student {
	private String studentIme;
	private String studentPrezime;
	private String studentBrojIndexa;
	private String studentGodina;

	Student() {

	}

	Student(String studentIme) {
		this.studentIme = studentIme;
	}

	Student(String studentIme, String studentPrezime) {
		this.studentIme = studentIme;
		this.studentPrezime = studentPrezime;

	}

	Student(String studentIme, String studentPrezime, String studentBrojIndexa) {
		this.studentIme = studentIme;
		this.studentPrezime = studentPrezime;
		this.studentBrojIndexa = studentBrojIndexa;

	}

	Student(String studentIme, String studentPrezime, String studentBrojIndexa,
			String studentGodina) {

		this.studentIme = studentIme;
		this.studentPrezime = studentPrezime;
		this.studentBrojIndexa = studentBrojIndexa;
		this.studentGodina = studentGodina;

	}

	public String getStudentIme() {
		return studentIme;
	}

	public void setStudentIme(String studentIme) {
		this.studentIme = studentIme;
	}

	public String getStudentPrezime() {
		return studentPrezime;
	}

	public void setStudentPrezime(String studentPrezime) {
		this.studentPrezime = studentPrezime;
	}

	public String getStudentBrojIndexa() {
		return studentBrojIndexa;
	}

	public void setStudentBrojIndexa(String studentBrojIndexa) {
		this.studentBrojIndexa = studentBrojIndexa;
	}

	public String getStudentGodina() {
		return studentGodina;
	}

	public void setStudentGodina(String studentGodina) {
		this.studentGodina = studentGodina;
	}

}
