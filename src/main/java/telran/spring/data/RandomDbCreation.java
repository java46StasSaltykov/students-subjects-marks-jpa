package telran.spring.data;

import java.util.*;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import telran.spring.data.model.*;
import telran.spring.data.service.CollegeService;

@Component
public class RandomDbCreation {
	
	private static Logger LOG = LoggerFactory.getLogger(RandomDbCreation.class);
	static Long studentId = 2L;
	static Long subjectId = 2L;
	Map<Long, Student> studentsMap = new HashMap<Long, Student>(); 
	Map<Long, Subject> subjectsMap = new HashMap<Long, Subject>(); 
	@Value("${app.marks.amount}")
	int marksAmount;
	
	@Autowired
	CollegeService collegeService;
	
	@PostConstruct
	void dbCreation() {
		collegeService.addStudent(new Student(1, "Vasya"));
		collegeService.addSubject(new Subject(1, "Java"));
		collegeService.addMark(new Mark(1, 1, 95));

		String[] names = { "Abraham", "Sarah", "Itshak", "Rahel", "Asaf", "Yacob", "Rivka", "Yosef", "Benyanim", "Dan",
				"Ruben", "Moshe", "Aron", "Yehashua", "David", "Salomon", "Nefertity", "Naftaly", "Natan", "Asher" };
		String subjects[] = { "Java core", "Java Technologies", "Spring Data", "Spring Security", "Spring Cloud", "CSS",
				"HTML", "JS", "React", "Material-UI" };

		Arrays.stream(names).forEach(s -> createStudent(s));
		LOG.debug("Students created.");
		Arrays.stream(subjects).forEach(s -> createSubject(s));
		LOG.debug("Subjects created.");
		Stream.generate(() -> new Mark(
				studentsMap.get((long) ((int) (Math.random() * names.length + 1))).id,
				subjectsMap.get((long) ((int) (Math.random() * subjects.length + 1))).id,
				(int) (Math.random() * 100 + 1)
				)).limit(marksAmount).forEach(m -> collegeService.addMark(m));
		LOG.debug("Marks added.");
	}
	
	void createStudent(String name) {
		Student newStudent = new Student(studentId, name);
		collegeService.addStudent(newStudent);
		studentsMap.put(newStudent.id, newStudent);
		studentId++;
	}
	void createSubject(String subject) {
		Subject newSubject = new Subject(subjectId, subject);
		collegeService.addSubject(newSubject);
		subjectsMap.put(newSubject.id, newSubject);
		subjectId++;
	}
}
