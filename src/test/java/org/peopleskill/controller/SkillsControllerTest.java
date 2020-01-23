package org.peopleskill.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.peopleskill.entity.PeopleEntity;
import org.peopleskill.entity.SkillEntity;
import org.peopleskill.repository.PeopleRepository;
import org.peopleskill.repository.SkillRepository;
import org.peopleskill.services.SkillService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)

public class SkillsControllerTest {
    private MockMvc mockMvc;

    @Mock
    private SkillsController skillsController;

    @Mock
    private SkillService service;

    @InjectMocks
    SkillRepository skillRepository = new SkillRepository() {
        @Override
        public List<SkillEntity> findAll() {
            final List<SkillEntity> skillList = new ArrayList<>();
            final SkillEntity skillEntity = new SkillEntity();
            skillEntity.setSkillId(1);
            skillEntity.setDescription("Java");
            skillList.add(skillEntity);
            return skillList;
        }

        @Override
        public List<SkillEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<SkillEntity> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends SkillEntity> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends SkillEntity> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<SkillEntity> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public SkillEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends SkillEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends SkillEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<SkillEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends SkillEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<SkillEntity> findById(Long aLong) {
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
        public void delete(SkillEntity skillEntity) {

        }

        @Override
        public void deleteAll(Iterable<? extends SkillEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends SkillEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends SkillEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends SkillEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends SkillEntity> boolean exists(Example<S> example) {
            return false;
        }
    };



    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(skillsController).build();
    }

    @Test
    public void getAllSkillsTest() throws Exception {
        final List<SkillEntity> skillList = new ArrayList<>();
        final SkillEntity skillEntity = new SkillEntity();
        skillEntity.setSkillId(1);
        skillEntity.setDescription("Java");
        skillList.add(skillEntity);

        when(service.getAllSkill()).thenReturn( skillList);
        final ObjectMapper objectMapper= new ObjectMapper();
         mockMvc.perform(
                MockMvcRequestBuilders.get("/skills"))
                .andExpect(handler().methodName("getAllSkills"))
                .andExpect(handler().handlerType(SkillsController.class))
                .andExpect(status().is2xxSuccessful())
                 .equals(skillList);
    }


    @Test
    public void getSkillByIdTest() throws Exception {
        final SkillEntity skillEntity = new SkillEntity();
        skillEntity.setSkillId(1);
        skillEntity.setDescription("Java");

        when(service.getSkillById((long)1)).thenReturn( skillEntity);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/skills/1"))
                .andExpect(handler().methodName("getSkillById"))
                .andExpect(handler().handlerType(SkillsController.class))
                .andExpect(status().is2xxSuccessful())
                .equals(skillEntity);
    }

    @Test
    public void createOrUpdateSkillTest() throws Exception {
        final SkillEntity skillEntity = new SkillEntity();
        skillEntity.setSkillId(1);
        skillEntity.setDescription("Java");

        when(service.createOrUpdateSkill(skillEntity)).thenReturn( skillEntity);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/skills?description="+skillEntity.getDescription()))
                .andExpect(handler().methodName("createOrUpdateSkill"))
                .andExpect(handler().handlerType(SkillsController.class))
                .andExpect(status().is2xxSuccessful())
                .equals(skillEntity);
    }


    @Test
    public void deleteSkillTest() throws Exception {
        final SkillEntity skillEntity = new SkillEntity();
        skillEntity.setSkillId(1);
        skillEntity.setDescription("Java");

        when(service.deleteSkillById((long)1)).thenReturn(true);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/skills/1"))
                .andExpect(handler().methodName("deleteSkillById"))
                .andExpect(handler().handlerType(SkillsController.class))
                .andExpect(status().is2xxSuccessful() );


    }

}