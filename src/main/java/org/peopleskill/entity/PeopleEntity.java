package org.peopleskill.entity;

import javax.persistence.*;

@Entity
@Table(name = "people", schema = "people_skills", catalog = "people_skills")
public class PeopleEntity {

    private long peopleId;
    private String surname;
    private String firstname;



    private String email;
    private String position;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "people_id", nullable = false)
    public long  getPeopleId() {
        return this.peopleId;
    }

    public void setPeopleId(long peopleId) {
        this.peopleId = peopleId;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 200)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 200)
    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "position", nullable = false, length = 80)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

