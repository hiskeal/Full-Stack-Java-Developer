package com.usa.payment.controller;

import com.usa.payment.Dto.PersonRequestDto;
import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.model.Person;
import com.usa.payment.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/createPerson")
    public ResponseDto createPerson(@RequestBody PersonRequestDto personRequestDto) {
         personService.createPerson(personRequestDto);
        return new ResponseDto(true, "Updated Account Successfully");
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseDto updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto personRequestDto) {
         personService.updatePerson(id,personRequestDto);
         return new ResponseDto(true, "Updated Account Successfully");
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseDto deletePersonById(@PathVariable("id") Long id) {
          personService.deletePersonById(id);

        return new ResponseDto(true, "Deleted Account Successfully");
    }

    @GetMapping("/listPerson")
    public List<Person> ListAll() {
        return personService.ListAll();
    }

    @GetMapping("/getPerson/{id}")
    public ResponseDto getPerson(@PathVariable Long id) {
         personService.getPersonById(id);

        return new ResponseDto(true, "Get Each Person Data By Id");
    }

//    @PutMapping("/active/{id}")
//    public ResponseDto active(@PathVariable Long id) {
//        return accountService.active(id);
//    }
}
