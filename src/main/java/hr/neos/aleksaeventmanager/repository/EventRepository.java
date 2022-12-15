package hr.neos.aleksaeventmanager.repository;

import hr.neos.aleksaeventmanager.entity.Event;
import org.springframework.data.jpa.repository.*;

public interface EventRepository extends JpaRepository<Event, Long> {
}
