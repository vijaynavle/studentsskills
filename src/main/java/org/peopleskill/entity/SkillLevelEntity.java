package org.peopleskill.entity;

import javax.persistence.*;

@Entity
@Table(name = "ref_skill_level", schema = "people_skills", catalog = "people_skills")
public class SkillLevelEntity {

    private long skillLevelId;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_level_id", nullable = false)
    public long  getSkillLevelId() {

        return skillLevelId;
    }

    public void setSkillLevelId(final long skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}

