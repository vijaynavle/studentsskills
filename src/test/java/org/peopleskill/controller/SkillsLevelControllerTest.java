package org.peopleskill.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.peopleskill.entity.SkillLevelEntity;
import org.peopleskill.repository.SkillLevelRepository;
import org.peopleskill.services.SkillLevelService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)

public class SkillsLevelControllerTest {
    private MockMvc mockMvc;

    @Mock
    private SkillLevelController skillLevelController;

    @Mock
    private SkillLevelService service;

    @InjectMocks
    SkillLevelRepository skillLevelRepository = new SkillLevelRepository() {
        @Override
        public List<SkillLevelEntity> findAll() {
            return null;
        }

        @Override
        public List<SkillLevelEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<SkillLevelEntity> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends SkillLevelEntity> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends SkillLevelEntity> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<SkillLevelEntity> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public SkillLevelEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends SkillLevelEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends SkillLevelEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<SkillLevelEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends SkillLevelEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<SkillLevelEntity> findById(Long aLong) {
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
        public void delete(SkillLevelEntity skillLevelEntity) {

        }

        @Override
        public void deleteAll(Iterable<? extends SkillLevelEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends SkillLevelEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends SkillLevelEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends SkillLevelEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends SkillLevelEntity> boolean exists(Example<S> example) {
            return false;
        }
    };



    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(skillLevelController).build();
    }

    @Test
    public void getAllSkillLevelTest() throws Exception {
        final List<SkillLevelEntity> skillList = new ArrayList<>();
        final SkillLevelEntity skillLevelEntity = new SkillLevelEntity();
        skillLevelEntity.setSkillLevelId(1);
        skillLevelEntity.setDescription("Expert");
        skillList.add(skillLevelEntity);

        when(service.getAllSkillLevel()).thenReturn( skillList);
        final ObjectMapper objectMapper= new ObjectMapper();
         mockMvc.perform(
                MockMvcRequestBuilders.get("/skilllevel"))
                .andExpect(handler().methodName("getAllSkillLevels"))
                .andExpect(handler().handlerType(SkillLevelController.class))
                .andExpect(status().is2xxSuccessful())
                 .equals(skillList);
    }


    @Test
    public void getSkillLevelByIdTest() throws Exception {
        final List<SkillLevelEntity> skillList = new ArrayList<>();
        final SkillLevelEntity skillLevelEntity = new SkillLevelEntity();
        skillLevelEntity.setSkillLevelId(1);
        skillLevelEntity.setDescription("Expert");
        skillList.add(skillLevelEntity);

        when(service.getSkillLevelById((long)1)).thenReturn( skillLevelEntity);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/skilllevel/1"))
                .andExpect(handler().methodName("getSkillLevelById"))
                .andExpect(handler().handlerType(SkillLevelController.class))
                .andExpect(status().is2xxSuccessful())
                .equals(skillLevelEntity);
    }

    @Test
    public void createOrUpdateSkillLevelTest() throws Exception {
        final List<SkillLevelEntity> skillList = new ArrayList<>();
        final SkillLevelEntity skillLevelEntity = new SkillLevelEntity();
        skillLevelEntity.setSkillLevelId(1);
        skillLevelEntity.setDescription("Expert");
        skillList.add(skillLevelEntity);

        when(service.createOrUpdateSkillLevel(skillLevelEntity)).thenReturn( skillLevelEntity);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/skilllevel?description="+skillLevelEntity.getDescription()))
                .andExpect(handler().methodName("createOrUpdateSkillLevel"))
                .andExpect(handler().handlerType(SkillLevelController.class))
                .andExpect(status().is2xxSuccessful())
                .equals(skillLevelEntity);
    }


    @Test
    public void deleteSkillLevelTest() throws Exception {
        final List<SkillLevelEntity> skillList = new ArrayList<>();
        final SkillLevelEntity skillLevelEntity = new SkillLevelEntity();
        skillLevelEntity.setSkillLevelId(1);
        skillLevelEntity.setDescription("Expert");
        skillList.add(skillLevelEntity);

        when(service.deleteSkillLevelById((long)1)).thenReturn(true);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/skilllevel/1"))
                .andExpect(handler().methodName("deleteSkillLevelById"))
                .andExpect(handler().handlerType(SkillLevelController.class))
                .andExpect(status().is2xxSuccessful() );


    }

}