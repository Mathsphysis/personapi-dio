package one.digitalinnovation.projects.mathsphysis.personapi.Service;

import one.digitalinnovation.projects.mathsphysis.personapi.dto.request.PersonDTO;
import one.digitalinnovation.projects.mathsphysis.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.projects.mathsphysis.personapi.entity.Person;
import one.digitalinnovation.projects.mathsphysis.personapi.mapper.PersonMapper;
import one.digitalinnovation.projects.mathsphysis.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID: " + savedPerson.getId())
                .build();
    }
}
