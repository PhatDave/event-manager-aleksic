package hr.neos.aleksaeventmanager.repository;

import hr.neos.aleksaeventmanager.entity.Mentor;
import org.springframework.data.jpa.repository.*;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}