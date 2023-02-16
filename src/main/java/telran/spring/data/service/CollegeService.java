package telran.spring.data.service;

import java.util.*;
import telran.spring.data.model.*;
import telran.spring.data.proj.*;

public interface CollegeService {

	void addStudent(Student student);
	void addSubject(Subject subject);
	void addMark(Mark mark);
	List<MarkProj> getMarksByNameSubject(String name, String subject);
	List<StudentSubjectMark> getMarksByName(String name);
}
