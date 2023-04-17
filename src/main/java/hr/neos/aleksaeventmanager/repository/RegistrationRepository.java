package hr.neos.aleksaeventmanager.repository;

import hr.neos.aleksaeventmanager.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
