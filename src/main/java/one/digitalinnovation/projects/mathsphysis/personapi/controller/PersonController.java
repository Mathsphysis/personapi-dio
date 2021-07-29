package one.digitalinnovation.projects.mathsphysis.personapi.controller;


import one.digitalinnovation.projects.mathsphysis.personapi.Service.PersonService;
import one.digitalinnovation.projects.mathsphysis.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.projects.mathsphysis.personapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
