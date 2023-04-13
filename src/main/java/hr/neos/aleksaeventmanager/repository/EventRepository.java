package hr.neos.aleksaeventmanager.repository;

import hr.neos.aleksaeventmanager.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    boolean existsByName(String name);
}
