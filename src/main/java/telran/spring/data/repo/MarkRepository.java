package telran.spring.data.repo;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import telran.spring.data.entities.MarkEntity;
import telran.spring.data.proj.*;

public interface MarkRepository extends JpaRepository<MarkEntity, Long> {

	List<MarkProj> findByStudentNameAndSubjectSubject(String name, String subject);
	
	@Query(value = 
			"select name, subject, mark "
			+ "from students join marks on "
			+ "students.stid = marks.stid join subjects on "
			+ "subjects.suid = marks.suid "
			+ "where students.name=:name", 
			nativeQuery = true)
	List<StudentSubjectMark> findByStudentName(String name);
}
