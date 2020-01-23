package org.peopleskill.entity;

import javax.persistence.*;

@Entity
@Table(name = "ref_skill", schema = "people_skills", catalog = "people_skills")
public class SkillEntity {

    private long skillId;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    public long  getSkillId() {
        return skillId;
    }

    public void setSkillId(final long skillId) {
        this.skillId = skillId;
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

