package org.peopleskill.controller;

import org.peopleskill.entity.PeopleEntity;
import org.peopleskill.exception.InvalidDataException;
import org.peopleskill.exception.RecordNotFoundException;
import org.peopleskill.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    PeopleService service;

    @GetMapping
    public ResponseEntity<List<PeopleEntity>> getAllPeoples() {
        List<PeopleEntity> list = service.getAllPeople();

        return new ResponseEntity<List<PeopleEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleEntity> getPeopleById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        PeopleEntity entity = service.getPeopleById(id);

        return new ResponseEntity<PeopleEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PeopleEntity> createOrUpdatePeople(PeopleEntity employee)
            throws RecordNotFoundException, InvalidDataException {
        PeopleEntity updated = service.createOrUpdatePeople(employee);
        return new ResponseEntity<PeopleEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePeopleById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deletePeopleById(id);
        return HttpStatus.OK;
    }
}
