package edu.StudentManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.StudentManagement.Model.Student;
import edu.StudentManagement.Service.StudentService;

import java.util.List;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	// Show all students
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "student";
	}

	// Show add student form
	@GetMapping("/add-student")
	public String showAddStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}

	// Save student
	@PostMapping("/save-student")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	// Show edit form
	@GetMapping("/edit-student/{id}")
	public String showEditForm(@PathVariable("id") int id, Model model) {
		Student student = studentService.fetchById(id);
		model.addAttribute("student", student);
		return "student-form";
	}

	// Delete student
	@GetMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		studentService.deleteById(id);
		return "redirect:/students";
	}

	// Fetch student by phone number
	@GetMapping("/student-by-phone/{phone}")
	public String getStudentByPhone(@PathVariable("phone") long phone, Model model) {
		Student students = studentService.fetchByPhone(phone);
		model.addAttribute("students", students);
		return "students";
	}

	// Fetch by standard
	@GetMapping("/students-by-standard")
	public String getStudentsByStandard(@RequestParam("standard") int standard, Model model) {
		List<Student> students = studentService.fetchByStandard(standard);
		model.addAttribute("students", students);
		return "student";
	}
	
	@GetMapping("/standard")
    public String showStandardPage() {
        return "standard"; 
    }
	
	@GetMapping("/address")
	public String showAddressPage() {
		return "address";
	}

	// Fetch by address
	@GetMapping("/students-by-address")
	public String getStudentsByAddress(@RequestParam("address") String address, Model model) {
		List<Student> students = studentService.fetchByAddress(address);
		model.addAttribute("students", students);
		return "student";
	}

	// Fetch only male students
	@GetMapping("/students-male")
	public String getOnlyMaleStudents(Model model) {
		List<Student> students = studentService.fetchOnlyMale();
		model.addAttribute("students", students);
		return "student";
	}

	// Fetch only female students
	@GetMapping("/students-female")
	public String getOnlyFemaleStudents(Model model) {
		List<Student> students = studentService.fetchOnlyFemale();
		model.addAttribute("students", students);
		return "student";
	}

	// Fetch by name, standard, and address
	@GetMapping("/students-by-name-standard-address/{standard}")
	public String fetchByNameStandardAddress(@PathVariable("standard") int standard, Model model) {
		List<Object[]> data = studentService.fetchByNameStandardAddress(standard);
		model.addAttribute("data", data);
		return "standard-form";
	}

	// Fetch only student names
	@GetMapping("/student-names")
	public String getOnlyNames(Model model) {
		List<String> names = studentService.getOnlyName();
		model.addAttribute("names", names);
		return "students";
	}
}
