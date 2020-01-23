package org.peopleskill.repository;

import org.peopleskill.entity.PeopleSkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleSkillsRepository extends JpaRepository<PeopleSkillsEntity, Long> {

}