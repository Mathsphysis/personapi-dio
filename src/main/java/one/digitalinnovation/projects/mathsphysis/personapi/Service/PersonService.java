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
        return getMessageResponseDTO("Created Person with ID: ", savedPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person personById = verifyIfExists(id);

        return personMapper.toDTO(personById);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        Person personById = verifyIfExists(id);

        personRepository.delete(personById);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);

        return getMessageResponseDTO("Updated Person with ID: ", updatedPerson.getId());
    }

    private MessageResponseDTO getMessageResponseDTO(String s, Long id) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
