package telran.spring.data.repo;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import telran.spring.data.entities.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

	@Query("select subject from SubjectEntity where id in "
			+ "(select subject.id from MarkEntity "
			+ "group by subject.id having count(mark) < :marksThreshold)")
	List<SubjectEntity> leastPopularSubjects(int marksThreshold);
	
}
