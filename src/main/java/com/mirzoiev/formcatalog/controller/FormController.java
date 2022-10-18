package com.mirzoiev.formcatalog.controller;

import com.mirzoiev.formcatalog.dto.FormDto;
import com.mirzoiev.formcatalog.entity.FormEntity;
import com.mirzoiev.formcatalog.service.FormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/form")
public class FormController {
    private Logger logger = LoggerFactory.getLogger(FormController.class);

    @Autowired
    private FormService formService;

    @GetMapping
    public List<FormEntity> formList() {
        logger.debug("Getting all forms");
        return formService.getAllFormList();
    }

    @GetMapping("/{id}")
    public FormEntity getFormById(@PathVariable("id") String id) {
        logger.debug("Getting form with ID: {}", id);

        return formService.getFormById(id);
    }

    @PostMapping
    public FormEntity createForm(@Valid @RequestBody FormDto formDto) {
        logger.debug("Saving form.");
        return formService.createForm(formDto.dtoToForm(formDto));
    }

    @PutMapping(value = "/{id}")
    public FormEntity updateForm(@Valid @RequestBody FormDto formDto, @PathVariable("id") String id) {
        logger.debug("Updating form with ID: {}", id);
        FormEntity form = formService.getFormById(id);
        return formService.updateForm(formDto.dtoToForm(form, formDto), id);
    }
    @DeleteMapping("/{id}")
    public void removeFormById(@PathVariable("id") String id) {
        logger.debug("Removing form with ID: {}", id);
        formService.removeFormById(id);
    }

}
