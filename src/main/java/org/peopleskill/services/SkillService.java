package org.peopleskill.services;

import org.peopleskill.entity.SkillEntity;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import org.peopleskill.exception.RecordNotFoundException;
import org.peopleskill.repository.SkillRepository;
import java.util.ArrayList;

@Service
public class SkillService {

    private static final String INVALID_DATA_MESSAGE = "Invalid Reference Data Supplied.";

    private final SkillRepository skillRepository;


    @Inject
    public SkillService(final  SkillRepository skillRepository ) {
        this.skillRepository = skillRepository;
    }



    public List<SkillEntity> getAllSkill()
    {

        List<SkillEntity> skillList = skillRepository.findAll();

        if(skillList.size() > 0) {
            return skillList;
        } else {
            return new ArrayList<SkillEntity>();
        }
    }

    public SkillEntity getSkillById(Long id) throws RecordNotFoundException
    {
        Optional<SkillEntity> skill = skillRepository.findById(id);

        if(skill.isPresent()) {
            return skill.get();
        } else {
            throw new RecordNotFoundException("No skill record exist for given id");
        }
    }

    public SkillEntity createOrUpdateSkill(SkillEntity entity)
    {
        Optional<SkillEntity> skill = skillRepository.findById(entity.getSkillId());

        if(skill.isPresent())
        {
            SkillEntity newEntity = skill.get();
            newEntity.setDescription(entity.getDescription());
            newEntity = skillRepository.save(newEntity);

            return newEntity;
        } else {
            entity = skillRepository.save(entity);

            return entity;
        }
    }

    public boolean deleteSkillById(Long id) throws RecordNotFoundException
    {

        Optional<SkillEntity> skill = skillRepository.findById(id);

        if(skill.isPresent())
        {
            skillRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No skill record exist for given id");
        }
        return true;
    }





}
