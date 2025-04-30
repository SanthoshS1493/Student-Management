package edu.StudentManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	private int id;
	private String name;
	private int standard;
	private String fatherName;
	private String gender;
	private String address;
	private long phone;
}
