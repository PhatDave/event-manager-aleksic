package hr.neos.aleksaeventmanager.repository;

import hr.neos.aleksaeventmanager.entity.Team;
import org.springframework.data.jpa.repository.*;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
