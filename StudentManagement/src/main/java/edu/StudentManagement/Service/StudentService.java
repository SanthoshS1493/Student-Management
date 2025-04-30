package edu.StudentManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.StudentManagement.Model.Student;
import edu.StudentManagement.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	// Save Student Details
	public void saveStudent(Student student) {
		repository.save(student);
	}

	// Fetch By Id
	public Student fetchById(int id) {
		Optional<Student> studentOptional = repository.findById(id);
		return studentOptional.orElse(null);
	}

	// Fetch Only Name
	public List<String> getOnlyName() {
		return repository.getOnlyName();
	}

	// Fetch By Phone Number
	public Student fetchByPhone(long phone) {
		return repository.fetchByPhone(phone);
	}

	// Fetch By Standard
	public List<Student> fetchByStandard(int standard) {
		return repository.fetchByStandard(standard);
	}

	// Fetch By Address
	public List<Student> fetchByAddress(String address) {
		return repository.fetchByAddress(address);
	}

	// Fetch Only Male
	public List<Student> fetchOnlyMale() {
		return repository.fetchOnlyMale();
	}

	// Fetch Only Female
	public List<Student> fetchOnlyFemale() {
		return repository.fetchOnlyFemale();
	}

	// Fetch By Name Standard Address
	public List<Object[]> fetchByNameStandardAddress(int standard) {
		return repository.fetchByNameStandardAddress(standard);
	}

	// Fetch all students
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	// Delete student by ID
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
