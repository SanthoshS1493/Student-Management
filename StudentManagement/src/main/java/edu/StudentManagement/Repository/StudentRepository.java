package edu.StudentManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.StudentManagement.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "select s.name from Student s")
	public List<String> getOnlyName();
	
	
	@Query(value = "select s from Student s where s.phone=:phone")
	public Student fetchByPhone(@Param("phone") long phone);
	
	@Query(value = "select s from Student s where s.standard In :standard")
	public List<Student> fetchByStandard(@Param("standard") int standard);
	
	
	@Query(value = "select s from Student s where s.address In :address")
	public List<Student> fetchByAddress(@Param("address") String address);

	
	@Query(value = "select s from Student s where s.gender = 'male'")
	public List<Student> fetchOnlyMale();

   @Query(value = "select s from Student s where s.gender='female'")
	public List<Student> fetchOnlyFemale();
   
   
   @Query(value = "select s.name,s.standard,s.address from Student s where s.standard In :standard")
   public List<Object[]> fetchByNameStandardAddress(@Param("standard") int standard);

}
