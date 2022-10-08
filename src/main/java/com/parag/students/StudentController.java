package com.parag.students;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	@PostMapping
	public Student save(@RequestBody StudentDto studentdto) {
		Student student=new Student();
		BeanUtils.copyProperties(studentdto, student);
		return repository.save(student);
	}
	
	@PutMapping("/{id}")
	public Student save(@PathVariable("id") Integer id, @RequestBody StudentDto studentDto) {
		Student s = repository.findById(id).orElse(null);
		if(s!=null) {
			s.setBirthDate(studentDto.getBirthDate());
			s.setGender(studentDto.getGender());
			s.setName(studentDto.getName());
			repository.save(s);
		}
		return s;
	}
	
	@GetMapping
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Student find(@PathVariable("id")Integer id){
		return repository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		Student student = repository.getById(id);
		log.info("Deleting " + student);
		repository.deleteById(id);
	}
}
