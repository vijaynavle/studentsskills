package org.peopleskill.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "people_skills", schema = "people_skills", catalog = "people_skills")
public class PeopleSkillsEntity {

    private long peopleSkillId;
    private long peopleId;
    private long skillId;
   private long skillLevelId;
    private Date startDate;
    private Date endDate;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "people_skillId", nullable = false)
    public long  getPeopleSkillId() {
        return this.peopleSkillId;
    }

    public void setPeopleSkillId(final long peopleSkillId) {
        this.peopleSkillId =   peopleSkillId;
    }


    @Column(name = "people_id", nullable = false)
    public long  getPeopleId() {
        return this.peopleId;
    }

    public void setPeopleId(final long peopleId) {
        this.peopleId =   peopleId;
    }


    @Basic
    @Column(name = "skill_id", nullable = false)
    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }
    @Basic
    @Column(name = "skill_level_id", nullable = false)
    public long getSkillLevelId() {
        return skillLevelId;
    }

    public void setSkillLevelId(long skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

    @Basic
    @Column(name = "startDate", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

