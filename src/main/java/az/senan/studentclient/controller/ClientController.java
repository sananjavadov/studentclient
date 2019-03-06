package az.senan.studentclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import az.senan.studentclient.model.Student;

@RestController
@RequestMapping("/")
public class ClientController {

	@Autowired	
	RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	ResponseEntity<Object> getId(@PathVariable("id") int id) {
		return restTemplate.getForEntity("http://localhost:8080/student/{id}", Object.class, id);		
	}
	
	@GetMapping
	ResponseEntity<Object> all() {
		return restTemplate.getForEntity("http://localhost:8080/student/", Object.class);
	}
		
	@PostMapping("/save")
	ResponseEntity<Object> save(@RequestBody Student s) {
		ResponseEntity<Object> smb=restTemplate.postForEntity("http://localhost:8080/student", s, Object.class);
		return new ResponseEntity<>(smb.getBody(),smb.getStatusCode());		
	}
	
	@PostMapping("/{id}")
	ResponseEntity<Object> update(@RequestBody Student s, @PathVariable("id") int id) {
		ResponseEntity<Object>  smb=restTemplate.postForEntity("http://localhost:8080/student/{id}", s, Object.class,id);
		return new ResponseEntity<>(smb.getBody(),smb.getStatusCode());
	}
	
	@DeleteMapping("/{id}")
	Object delete(@PathVariable("id") int id) { 
		return restTemplate.exchange("http://localhost:8080/student/{id}", HttpMethod.DELETE, null, Object.class, id);				
	}

}
