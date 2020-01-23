package org.peopleskill.services;

import org.peopleskill.entity.SkillLevelEntity;
import org.peopleskill.exception.RecordNotFoundException;
import org.peopleskill.repository.SkillLevelRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SkillLevelService {

    private static final String INVALID_DATA_MESSAGE = "Invalid Reference Data Supplied.";

    private final SkillLevelRepository  skillLevelRepository;


    @Inject
    public SkillLevelService(final  SkillLevelRepository  skillLevelRepository ) {
        this. skillLevelRepository =  skillLevelRepository;
    }



    public List<SkillLevelEntity> getAllSkillLevel()
    {

        List<SkillLevelEntity> skillList =  skillLevelRepository.findAll();

        if(skillList.size() > 0) {
            return skillList;
        } else {
            return new ArrayList<SkillLevelEntity>();
        }
    }

    public SkillLevelEntity getSkillLevelById(Long id) throws RecordNotFoundException
    {
        Optional<SkillLevelEntity> skill =  skillLevelRepository.findById(id);

        if(skill.isPresent()) {
            return skill.get();
        } else {
            throw new RecordNotFoundException("No skill record exist for given id");
        }
    }

    public SkillLevelEntity createOrUpdateSkillLevel(SkillLevelEntity entity)
    {
        Optional<SkillLevelEntity> skill =  skillLevelRepository.findById(entity.getSkillLevelId());

        if(skill.isPresent())
        {
            SkillLevelEntity newEntity = skill.get();
            newEntity.setDescription(entity.getDescription());
            newEntity =  skillLevelRepository.save(newEntity);

            return newEntity;
        } else {
            entity =  skillLevelRepository.save(entity);

            return entity;
        }
    }

    public boolean deleteSkillLevelById(Long id) throws RecordNotFoundException
    {
        Optional<SkillLevelEntity> skill =  skillLevelRepository.findById(id);

        if(skill.isPresent())
        {
             skillLevelRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No skill record exist for given id");
        }
        return true;
    }





}
