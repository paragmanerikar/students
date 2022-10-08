package com.parag.students;

import java.time.LocalDate;

import lombok.Data;
@Data
public class StudentDto {
	private int id;
	private String name;
	private String gender;
	private LocalDate birthDate;
}
