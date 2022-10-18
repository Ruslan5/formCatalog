package com.mirzoiev.formcatalog.service;

import com.mirzoiev.formcatalog.entity.FormEntity;
import com.mirzoiev.formcatalog.entity.Gender;
import com.mirzoiev.formcatalog.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

//    private static List<FormEntity> items = new ArrayList<>();
//
//    static {
//        List<String> femaleProfessions = new ArrayList<>();
//        femaleProfessions.add("FEMALE_Profession_1");
//        femaleProfessions.add("FEMALE_Profession_2");
//        femaleProfessions.add("FEMALE_Profession_3");
//
//        List<String> maleProfessions = new ArrayList<>();
//        maleProfessions.add("MALE_Profession_1");
//        maleProfessions.add("MALE_Profession_2");
//
//        items.add(new FormEntity("lname1", "fname", "sname", "bdate", Gender.FEMALE, femaleProfessions));
//        items.add(new FormEntity("lname4", "fname4", "sname4", "bdate4", Gender.MALE, maleProfessions));
//    }
//
//    @PostConstruct
//    public void init() {
//        formRepository.saveAll(items);
//    }

    public List<FormEntity> getAllFormList() {
        return formRepository.findAll();
    }

    public FormEntity getFormById(String id) {
        return formRepository.getFormById(id);
    }

    public FormEntity createForm(FormEntity form) {
        return formRepository.save(form);
    }

    public FormEntity updateForm(FormEntity form, String id) {
        return formRepository.save(form);
    }

    public void removeFormById(String id) {
        formRepository.deleteById(id);
    }
}
