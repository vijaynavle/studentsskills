package org.peopleskill.repository;

import org.peopleskill.entity.SkillLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillLevelRepository extends JpaRepository<SkillLevelEntity, Long> {

}