package one.digitalinnovation.projects.mathsphysis.personapi.Service;

import one.digitalinnovation.projects.mathsphysis.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.projects.mathsphysis.personapi.entity.Person;
import one.digitalinnovation.projects.mathsphysis.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID: " + savedPerson.getId())
                .build();
    }
}
