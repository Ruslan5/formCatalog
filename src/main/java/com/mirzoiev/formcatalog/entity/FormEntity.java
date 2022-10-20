package com.mirzoiev.formcatalog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class FormEntity {
    @Id
    private String id;
    private String lastname;
    private String firstname;
    private String secondname;
    private String birthday;
    private Gender gender;
    private String profession;

    public FormEntity() {
    }

    public FormEntity(String lastname,
                      String firstname,
                      String secondname,
                      String birthday,
                      Gender gender,
                      String profession) {

        this.lastname = lastname;
        this.firstname = firstname;
        this.secondname = secondname;
        this.birthday = birthday;
        this.gender = gender;
        this.profession = profession;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
