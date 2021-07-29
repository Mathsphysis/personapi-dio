package one.digitalinnovation.projects.mathsphysis.personapi.repository;

import one.digitalinnovation.projects.mathsphysis.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
