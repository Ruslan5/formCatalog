package com.mirzoiev.formcatalog.service;

import com.mirzoiev.formcatalog.entity.FormEntity;
import com.mirzoiev.formcatalog.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;
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
