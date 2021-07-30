package one.digitalinnovation.projects.mathsphysis.personapi.Service;

import one.digitalinnovation.projects.mathsphysis.personapi.dto.request.PersonDTO;
import one.digitalinnovation.projects.mathsphysis.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.projects.mathsphysis.personapi.entity.Person;
import one.digitalinnovation.projects.mathsphysis.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.projects.mathsphysis.personapi.mapper.PersonMapper;
import one.digitalinnovation.projects.mathsphysis.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID: " + savedPerson.getId())
                .build();
    }


    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person personById = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(personById);
    }
}
