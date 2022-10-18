package com.mirzoiev.formcatalog.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mirzoiev.formcatalog.entity.FormEntity;
import com.mirzoiev.formcatalog.entity.Gender;
import com.mirzoiev.formcatalog.repository.FormRepository;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class SpringBootConfig {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Mir")
    public void seedDatabase(FormRepository formRepository) {
        List<String> femaleProfessions = new ArrayList<>();
        femaleProfessions.add("FEMALE_Profession_1");
        femaleProfessions.add("FEMALE_Profession_2");
        femaleProfessions.add("FEMALE_Profession_3");

        List<String> maleProfessions = new ArrayList<>();
        maleProfessions.add("MALE_Profession_1");
        maleProfessions.add("MALE_Profession_2");

        List<FormEntity> expenseList = new ArrayList<>();
        expenseList.add(createNewEntity("lname1", "fname",
                "sname", "bdate",
                Gender.FEMALE, femaleProfessions));
        expenseList.add(createNewEntity("lname4", "fname4",
                "sname4", "bdate4",
                Gender.MALE, maleProfessions));

        formRepository.insert(expenseList);
    }

    private FormEntity createNewEntity(String lastname,
                                       String firstname,
                                       String secondname,
                                       String birthday,
                                       Gender gender,
                                       List<String> profession) {
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
