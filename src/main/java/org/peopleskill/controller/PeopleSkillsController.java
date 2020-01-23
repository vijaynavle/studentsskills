package org.peopleskill.controller;

import org.peopleskill.entity.PeopleSkillsEntity;
import org.peopleskill.exception.InvalidDataException;
import org.peopleskill.exception.RecordNotFoundException;
import org.peopleskill.services.PeopleSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peopleskills")
public class PeopleSkillsController {
    @Autowired
    PeopleSkillsService service;

    @GetMapping
    public ResponseEntity<List<PeopleSkillsEntity>> getAllPeopleSkillss() {
        List<PeopleSkillsEntity> list = service.getAllPeopleSkills();

        return new ResponseEntity<List<PeopleSkillsEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleSkillsEntity> getPeopleSkillsById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        PeopleSkillsEntity entity = service.getPeopleSkillsById(id);

        return new ResponseEntity<PeopleSkillsEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PeopleSkillsEntity> createOrUpdatePeopleSkills(PeopleSkillsEntity peopleSkillsEntity)
            throws RecordNotFoundException, InvalidDataException {
        PeopleSkillsEntity updated = service.createOrUpdatePeopleSkills(peopleSkillsEntity);
        return new ResponseEntity<PeopleSkillsEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePeopleSkillsById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deletePeopleSkillsById(id);
        return HttpStatus.OK;
    }
}
