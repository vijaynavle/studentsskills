package org.peopleskill.services;

import org.apache.commons.lang3.StringUtils;
import org.peopleskill.entity.PeopleSkillsEntity;
import org.peopleskill.exception.InvalidDataException;
import org.peopleskill.exception.RecordNotFoundException;
import org.peopleskill.repository.PeopleRepository;
import org.peopleskill.repository.PeopleSkillsRepository;
import org.peopleskill.repository.SkillLevelRepository;
import org.peopleskill.repository.SkillRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleSkillsService {

    private static final String INVALID_DATA_MESSAGE = "Invalid Reference Data Supplied.";

    private final PeopleSkillsRepository  peopleSkillsRepository;
    private final SkillService skillService;
    private final SkillLevelService  skillLevelService;
    private final PeopleService peopleService;

    @Inject
    public PeopleSkillsService(final  PeopleSkillsRepository  peopleSkillsRepository,
                               final  SkillService skillService,
                               final SkillLevelService  skillLevelService,
                               final PeopleService peopleService ) {
        this. peopleSkillsRepository =  peopleSkillsRepository;
        this.skillService =skillService;
        this.skillLevelService=skillLevelService;
        this.peopleService = peopleService;
    }



    public List<PeopleSkillsEntity> getAllPeopleSkills()
    {

        List<PeopleSkillsEntity> skillList =  peopleSkillsRepository.findAll();

        if(skillList.size() > 0) {
            return skillList;
        } else {
            return new ArrayList<PeopleSkillsEntity>();
        }
    }

    public PeopleSkillsEntity getPeopleSkillsById(Long id) throws RecordNotFoundException
    {
        Optional<PeopleSkillsEntity> skill =  peopleSkillsRepository.findById(id);

        if(skill.isPresent()) {
            return skill.get();
        } else {
            throw new RecordNotFoundException("No skill record exist for given id");
        }
    }

    public PeopleSkillsEntity createOrUpdatePeopleSkills(PeopleSkillsEntity entity) throws  InvalidDataException, RecordNotFoundException
    {

        // check for required manditory values

        if (entity.getPeopleId() < 1 ){
            throw new InvalidDataException("peopleId value is manditory. Please provide it.");
        }else{
            peopleService.getPeopleById(entity.getPeopleId());
        }

        if (entity.getSkillId() < 1 ){
            throw new InvalidDataException("skillId value is manditory. Please provide it.");
        }else{
           skillService.getSkillById(entity.getSkillId());
        }

        if (entity.getSkillLevelId() < 1 ){
            throw new InvalidDataException("skill_level_id value is manditory. Please provide it.");
        }else{
            skillLevelService.getSkillLevelById(entity.getSkillLevelId());
        }

        if (entity.getStartDate() ==null){
            throw new InvalidDataException("startDate value is manditory. Please provide it.");
        }

        Optional<PeopleSkillsEntity> skill =  peopleSkillsRepository.findById(entity.getPeopleSkillId());

        if(skill.isPresent())
        {
            PeopleSkillsEntity newEntity = skill.get();
            newEntity.setPeopleId(entity.getPeopleId());
            newEntity.setSkillId(entity.getSkillId());
            newEntity.setSkillLevelId(entity.getSkillLevelId());
            newEntity.setStartDate(entity.getStartDate());
            newEntity.setEndDate(entity.getEndDate());
            newEntity =  peopleSkillsRepository.save(newEntity);

            return newEntity;
        } else {
            entity =  peopleSkillsRepository.save(entity);

            return entity;
        }
    }

    public boolean deletePeopleSkillsById(Long id) throws RecordNotFoundException
    {
        Optional<PeopleSkillsEntity> skill =  peopleSkillsRepository.findById(id);

        if(skill.isPresent())
        {
             peopleSkillsRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No people_skill_id record exist for given id");
        }
        return true;
    }





}
