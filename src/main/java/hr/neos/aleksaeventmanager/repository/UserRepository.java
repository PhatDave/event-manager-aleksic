package hr.neos.aleksaeventmanager.repository;

import hr.neos.aleksaeventmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
