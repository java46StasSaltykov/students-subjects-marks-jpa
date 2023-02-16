package telran.spring.data.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import telran.spring.data.proj.*;
import telran.spring.data.service.CollegeService;

@RestController
@RequestMapping("college")
public class CollegeController {
	
	@Autowired
	CollegeService collegeService;
	
	@GetMapping("marks")
	List<MarkProj> getMarksByNameSubject(@RequestParam(name = "subject") String subject, 
			@RequestParam(name = "name") String name) {
		return collegeService.getMarksByNameSubject(name, subject);
	}

	@GetMapping("marks/subjects")
	List<StudentSubjectMark> getMarksByName(@RequestParam(name = "name") String name) {
		return collegeService.getMarksByName(name);
	}
}
