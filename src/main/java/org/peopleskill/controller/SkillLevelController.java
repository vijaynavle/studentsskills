package org.peopleskill.controller;

import org.peopleskill.entity.SkillLevelEntity;
import org.peopleskill.exception.RecordNotFoundException;
import org.peopleskill.services.SkillLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skilllevel")
public class SkillLevelController {
    @Autowired
    SkillLevelService service;

    @GetMapping
    public ResponseEntity<List<SkillLevelEntity>> getAllSkillLevels() {
        List<SkillLevelEntity> list = service.getAllSkillLevel();

        return new ResponseEntity<List<SkillLevelEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillLevelEntity> getSkillLevelById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        SkillLevelEntity entity = service.getSkillLevelById(id);

        return new ResponseEntity<SkillLevelEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SkillLevelEntity> createOrUpdateSkillLevel(SkillLevelEntity employee)
            throws RecordNotFoundException {
        SkillLevelEntity updated = service.createOrUpdateSkillLevel(employee);
        return new ResponseEntity<SkillLevelEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSkillLevelById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteSkillLevelById(id);
        return HttpStatus.OK;
    }
}
