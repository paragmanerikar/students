package com.parag.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	@PostMapping
	public Student save(@RequestBody Student student) {
		Student savedStudent = repository.save(student);
		return savedStudent;
	}
	
	@PutMapping("/{id}")
	public Student save(@PathVariable("id") Integer id, @RequestBody Student student) {
		Student s = repository.findById(id).get();
		s.setBirthDate(student.getBirthDate());
		s.setGender(student.getGender());
		s.setName(s.getName());
		repository.save(s);
		return s;
	}
	
	@GetMapping
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Student find(@PathVariable("id")Integer id){
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		Student student = repository.getById(id);
		System.out.println("Deleting " + student);
		repository.deleteById(id);
	}
}
