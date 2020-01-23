package org.peopleskill.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.peopleskill.entity.PeopleEntity;
import org.peopleskill.repository.PeopleRepository;
import org.peopleskill.services.PeopleService;
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

public class PeopleControllerTest {
    private MockMvc mockMvc;

    @Mock
    private PeopleController peoplesController;

    @Mock
    private PeopleService service;

    @InjectMocks
    PeopleRepository peopleRepository = new PeopleRepository() {
        @Override
        public List<PeopleEntity> findAll() {
            return null;
        }

        @Override
        public List<PeopleEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<PeopleEntity> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends PeopleEntity> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends PeopleEntity> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<PeopleEntity> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public PeopleEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends PeopleEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends PeopleEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<PeopleEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends PeopleEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<PeopleEntity> findById(Long aLong) {
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
        public void delete(PeopleEntity peopleEntity) {

        }

        @Override
        public void deleteAll(Iterable<? extends PeopleEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends PeopleEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends PeopleEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends PeopleEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends PeopleEntity> boolean exists(Example<S> example) {
            return false;
        }
    };



    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(peoplesController).build();
    }

    @Test
    public void getAllPeopleTest() throws Exception {
        final List<PeopleEntity> peopleList = new ArrayList<>();
        final PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setPeopleId(1);
        peopleEntity.setSurname("Navle");
        peopleEntity.setFirstname("Vijay");

        peopleList.add(peopleEntity);

        when(service.getAllPeople()).thenReturn( peopleList);
        final ObjectMapper objectMapper= new ObjectMapper();
         mockMvc.perform(
                MockMvcRequestBuilders.get("/people"))
                .andExpect(handler().methodName("getAllPeoples"))
                .andExpect(handler().handlerType(PeopleController.class))
                .andExpect(status().is2xxSuccessful())
                 .equals(peopleList);
    }


    @Test
    public void getPeopleByIdTest() throws Exception {
        final List<PeopleEntity> peopleList = new ArrayList<>();
        final PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setPeopleId(1);
        peopleEntity.setSurname("Navle");
        peopleEntity.setFirstname("Vijay");

        when(service.getPeopleById((long)1)).thenReturn( peopleEntity);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/people/1"))
                .andExpect(handler().methodName("getPeopleById"))
                .andExpect(handler().handlerType(PeopleController.class))
                .andExpect(status().is2xxSuccessful())
                .equals(peopleEntity);
    }

    @Test
    public void createOrUpdatePeopleTest() throws Exception {
        final List<PeopleEntity> peopleList = new ArrayList<>();
        final PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setPeopleId(1);
        peopleEntity.setSurname("Navle");
        peopleEntity.setFirstname("Vijay");

        when(service.createOrUpdatePeople(peopleEntity)).thenReturn( peopleEntity);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/people?surname="+peopleEntity.getSurname()+"&firstname="+peopleEntity.getFirstname()))
                .andExpect(handler().methodName("createOrUpdatePeople"))
                .andExpect(handler().handlerType(PeopleController.class))
                .andExpect(status().is2xxSuccessful())
                .equals(peopleEntity);
    }


    @Test
    public void deletePeopleTest() throws Exception {
        final List<PeopleEntity> peopleList = new ArrayList<>();
        final PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setPeopleId(1);
        peopleEntity.setSurname("Navle");
        peopleEntity.setFirstname("Vijay");

        when(service.deletePeopleById((long)1)).thenReturn(true);
        final ObjectMapper objectMapper= new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/people/1"))
                .andExpect(handler().methodName("deletePeopleById"))
                .andExpect(handler().handlerType(PeopleController.class))
                .andExpect(status().is2xxSuccessful() );


    }

}