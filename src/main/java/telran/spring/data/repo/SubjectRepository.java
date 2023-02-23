package telran.spring.data.repo;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import telran.spring.data.entities.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

	@Query("select course from SubjectEntity course where id in "
			+ "(select ms.id from MarkEntity me right join me.subject ms "
			+ "group by ms.id having count(mark) < :marksThreshold)")
	List<SubjectEntity> unpopularSubjects(long marksThreshold);
	
}
