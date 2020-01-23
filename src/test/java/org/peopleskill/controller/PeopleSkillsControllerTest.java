package org.peopleskill.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.peopleskill.entity.PeopleSkillsEntity;
import org.peopleskill.repository.PeopleSkillsRepository;
import org.peopleskill.services.PeopleSkillsService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)

public class PeopleSkillsControllerTest {
    private MockMvc mockMvc;

    @Mock
    private PeopleSkillsController peopleSkillsController;

    @Mock
    private PeopleSkillsService service;

    @InjectMocks
    PeopleSkillsRepository peopleSkillsRepository = new PeopleSkillsRepository() {
        @Override
        public List<PeopleSkillsEntity> findAll() {
            return null;
        }

        @Override
        public List<PeopleSkillsEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<PeopleSkillsEntity> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends PeopleSkillsEntity> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends PeopleSkillsEntity> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<PeopleSkillsEntity> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public PeopleSkillsEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends PeopleSkillsEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends PeopleSkillsEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<PeopleSkillsEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends PeopleSkillsEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<PeopleSkillsEntity> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(PeopleSkillsEntity peopleSkillsEntity) {

        }

        @Override
        public void deleteAll(Iterable<? extends PeopleSkillsEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends PeopleSkillsEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends PeopleSkillsEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends PeopleSkillsEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends PeopleSkillsEntity> boolean exists(Example<S> example) {
            return false;
        }
    };




    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(peopleSkillsController).build();
    }

    @Test
    public void getAllPeopleSkillsTest() throws Exception {
        final List<PeopleSkillsEntity> peopleSkillsList = new ArrayList<>();
        final PeopleSkillsEntity peopleSkillsEntity = new PeopleSkillsEntity();
        peopleSkillsEntity.setPeopleSkillId(1);
        peopleSkillsEntity.setSkillId(1);
        peopleSkillsEntity.setPeopleId(1);
        peopleSkillsEntity.setStartDate(new Date(50000));
        peopleSkillsList.add(peopleSkillsEntity);

        when(service.getAllPeopleSkills()).thenReturn( peopleSkillsList);
        final ObjectMapper objectMapper= new ObjectMapper();
         mockMvc.perform(
                MockMvcRequestBuilders.get("/peopleskills"))
                .andExpect(handler().methodName("getAllPeopleSkillss"))
                .andExpect(handler().handlerType(PeopleSkillsController.class))
                .andExpect(status().is2xxSuccessful())
                 .equals(peopleSkillsList);
    }


    @Test
    public void getPeopleSkillsByIdTest() throws Exception {
        final List<PeopleSkillsEntity> peopleSkillsList = new ArrayList<>();
        final PeopleSkillsEntity peopleSkillsEntity = new PeopleSkillsEntity();
        peopleSkillsEntity.setPeopleSkillId(1);
        peopleSkillsEntity.setSkillId(1);
        peopleSkillsEntity.setPeopleId(1);
        peopleSkillsEntity.setStartDate(new Date(50000));
        peopleSkillsList.add(peopleSkillsEntity);

        when(service.getPeopleSkillsById((long)1)).thenReturn( peopleSkillsEntity);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/peopleskills/1"))
                .andExpect(handler().methodName("getPeopleSkillsById"))
                .andExpect(handler().handlerType(PeopleSkillsController.class))
                .andExpect(status().is2xxSuccessful())
                .equals(peopleSkillsEntity);
    }

    @Test
    public void createOrUpdatePeopleSkillsTest() throws Exception {
        final List<PeopleSkillsEntity> peopleSkillsList = new ArrayList<>();
        final PeopleSkillsEntity peopleSkillsEntity = new PeopleSkillsEntity();
        peopleSkillsEntity.setPeopleSkillId(1);
        peopleSkillsEntity.setSkillId(1);
        peopleSkillsEntity.setPeopleId(1);
        peopleSkillsEntity.setStartDate(new Date(50000));
        peopleSkillsList.add(peopleSkillsEntity);

        when(service.createOrUpdatePeopleSkills(peopleSkillsEntity)).thenReturn( peopleSkillsEntity);
        final ObjectMapper objectMapper= new ObjectMapper();
        String stringBuilder ="/peopleskills??peopleId="+peopleSkillsEntity.getPeopleId()+"&skillId="+peopleSkillsEntity.getSkillId()+"&skillLevelId="+ peopleSkillsEntity.getSkillLevelId() +"&startDate=2010-01-01";
        mockMvc.perform(
                MockMvcRequestBuilders.post(stringBuilder))
                .andExpect(handler().methodName("createOrUpdatePeopleSkills"))
                .andExpect(handler().handlerType(PeopleSkillsController.class))
                .andExpect(status().is2xxSuccessful())
                .equals(peopleSkillsEntity);
    }


    @Test
    public void deletePeopleSkillsTest() throws Exception {
        final List<PeopleSkillsEntity> peopleSkillsList = new ArrayList<>();
        final PeopleSkillsEntity peopleSkillsEntity = new PeopleSkillsEntity();
        peopleSkillsEntity.setPeopleSkillId(1);
        peopleSkillsEntity.setSkillId(1);
        peopleSkillsEntity.setPeopleId(1);
        peopleSkillsEntity.setStartDate(new Date(50000));
        peopleSkillsList.add(peopleSkillsEntity);

        when(service.deletePeopleSkillsById((long)1)).thenReturn(true);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/peopleskills/1"))
                .andExpect(handler().methodName("deletePeopleSkillsById"))
                .andExpect(handler().handlerType(PeopleSkillsController.class))
                .andExpect(status().is2xxSuccessful() );


    }

}