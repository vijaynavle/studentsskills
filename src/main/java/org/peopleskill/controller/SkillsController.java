package org.peopleskill.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.peopleskill.services.SkillService;
import org.peopleskill.entity.SkillEntity;
import org.peopleskill.exception.RecordNotFoundException;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    SkillService service;

    @GetMapping
    public ResponseEntity<List<SkillEntity>> getAllSkills() {
        List<SkillEntity> list = service.getAllSkill();

        return new ResponseEntity<List<SkillEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillEntity> getSkillById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        SkillEntity entity = service.getSkillById(id);

        return new ResponseEntity<SkillEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SkillEntity> createOrUpdateSkill(SkillEntity employee)
            throws RecordNotFoundException {
        SkillEntity updated = service.createOrUpdateSkill(employee);
        return new ResponseEntity<SkillEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSkillById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteSkillById(id);
        return HttpStatus.OK;
    }
}
