package com.mirzoiev.formcatalog.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mirzoiev.formcatalog.entity.FormEntity;
import com.mirzoiev.formcatalog.entity.Gender;
import com.mirzoiev.formcatalog.repository.FormRepository;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ChangeLog
public class SpringBootConfig {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Mir")
    public void seedDatabase(FormRepository formRepository) {

        List<FormEntity> initList = new ArrayList<>();
        initList.add(createNewEntity("lname1", "fname1",
                "sname1", "2001-01-01",
                Gender.FEMALE, "FEMALE_Profession_1"));
        initList.add(createNewEntity("lname2", "fname2",
                "sname2", "2002-02-02",
                Gender.FEMALE, "FEMALE_Profession_2"));
        initList.add(createNewEntity("lname3", "fname3",
                "sname3", "2003-03-03",
                Gender.FEMALE, "FEMALE_Profession_3"));
        initList.add(createNewEntity("lname4", "fname4",
                "sname4", "bdate4",
                Gender.MALE, "MALE_Profession_1"));
        initList.add(createNewEntity("lname5", "fname5",
                "sname5", "bdate5",
                Gender.MALE, "MALE_Profession_2"));

        formRepository.insert(initList);
    }

    private FormEntity createNewEntity(String lastname,
                                       String firstname,
                                       String secondname,
                                       String birthday,
                                       Gender gender,
                                       String profession) {
        FormEntity entity = new FormEntity();
        entity.setLastname(lastname);
        entity.setFirstname(firstname);
        entity.setSecondname(secondname);
        entity.setBirthday(birthday);
        entity.setGender(gender);
        entity.setProfession(profession);
        return entity;
    }
}
