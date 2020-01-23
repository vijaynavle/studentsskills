package org.peopleskill.services;

import org.peopleskill.entity.PeopleEntity;
import org.peopleskill.exception.InvalidDataException;
import org.peopleskill.exception.RecordNotFoundException;
import org.peopleskill.repository.PeopleRepository;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private static final String INVALID_DATA_MESSAGE = "Invalid Reference Data Supplied.";

    private final PeopleRepository peopleRepository;



    @Inject
    public PeopleService(final  PeopleRepository peopleRepository ) {
        this.peopleRepository = peopleRepository;
    }



    public List<PeopleEntity> getAllPeople()
    {

        List<PeopleEntity> peopleList = peopleRepository.findAll();

        if(peopleList.size() > 0) {
            return peopleList;
        } else {
            return new ArrayList<PeopleEntity>();
        }
    }

    public PeopleEntity getPeopleById(Long id) throws RecordNotFoundException
    {
        Optional<PeopleEntity> people = peopleRepository.findById(id);

        if(people.isPresent()) {
            return people.get();
        } else {
            throw new RecordNotFoundException("No people record exist for given id");
        }
    }

    public PeopleEntity createOrUpdatePeople(PeopleEntity entity) throws InvalidDataException
    {


        // check for required manditory values

        if (StringUtils.isBlank( entity.getSurname())){
                throw new InvalidDataException("Surname is mandiatory value. Please provide it.");
        }
        if (StringUtils.isBlank( entity.getFirstname())){
           throw new InvalidDataException("Firstname is mandiatory value. Please provide it.");
        }


        Optional<PeopleEntity> people = peopleRepository.findById(entity.getPeopleId());
        if(people.isPresent())
        {
            PeopleEntity newEntity = people.get();
            newEntity.setSurname(entity.getSurname());
            newEntity.setFirstname(entity.getFirstname());
            if (!StringUtils.isBlank( entity.getEmail())) {
                newEntity.setEmail(entity.getEmail());
            }
            if (!StringUtils.isBlank( entity.getPosition())) {
                newEntity.setPosition(entity.getPosition());
            }
            newEntity = peopleRepository.save(newEntity);
            return newEntity;
        } else {
            entity = peopleRepository.save(entity);
            return entity;
        }
    }

    public boolean deletePeopleById(Long id) throws RecordNotFoundException
    {

        Optional<PeopleEntity> people = peopleRepository.findById(id);

        if(people.isPresent())
        {
            peopleRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No people record exist for given id");
        }
        return true;
    }





}
