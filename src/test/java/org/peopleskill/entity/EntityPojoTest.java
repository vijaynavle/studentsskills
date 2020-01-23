package org.peopleskill.entity;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsForAll;

@RunWith(MockitoJUnitRunner.class)
public class EntityPojoTest {

    @Test
    public void MarkedClassTest() {
        final Class<?> peopleEntity = PeopleEntity.class;
        final Class<?> peopleSkillEntity =  PeopleSkillsEntity.class;
        final Class<?> skillEntity = SkillEntity.class;
        final Class<?> skillLevelEntity = SkillLevelEntity.class;
        assertPojoMethodsForAll(peopleEntity,peopleSkillEntity, skillEntity,skillLevelEntity)
                .testing(Method.GETTER, Method.SETTER)
                .testing(Method.CONSTRUCTOR)
                .areWellImplemented();
    }
}