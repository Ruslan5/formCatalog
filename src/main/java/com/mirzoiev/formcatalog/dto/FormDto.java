package com.mirzoiev.formcatalog.dto;

import com.mirzoiev.formcatalog.entity.FormEntity;
import com.mirzoiev.formcatalog.entity.Gender;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Validated
public class FormDto {
    private String id;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    @NotBlank
    private String firstname;
    private String secondname;

    @NotNull(message = "date must not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Past date exception")
    private Date birthday;

    private String gender;
    @NotNull
    @NotBlank
    private String profession;

    public FormDto() {
    }

    public FormDto(String lastname,
                   String firstname,
                   String secondname,
                   Date birthday,
                   String gender,
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public FormEntity dtoToForm(FormDto formDTO) {
        FormEntity form = new FormEntity();
        form.setId(form.getId());
        form.setLastname(formDTO.getLastname());
        form.setFirstname(formDTO.getFirstname());
        form.setSecondname(formDTO.getSecondname());

        String formatDateString = new SimpleDateFormat("MM/dd/yyyy")
                .format(formDTO.getBirthday());
        form.setBirthday(formatDateString);

        if (formDTO.getGender().equalsIgnoreCase(String.valueOf(Gender.FEMALE))) {
            form.setGender(Gender.FEMALE);
        }
        if ((formDTO.getGender().equalsIgnoreCase(String.valueOf(Gender.MALE)))) {
            form.setGender(Gender.MALE);
        }
        List<String> professions = new ArrayList<>();
        professions.add(formDTO.getProfession());
        form.setProfession(professions);
        return form;
    }

    public FormEntity dtoToForm(FormEntity form, FormDto formDTO) {
        form.setLastname(formDTO.getLastname());
        form.setFirstname(formDTO.getFirstname());
        form.setSecondname(formDTO.getSecondname());
        String formatDateString = new SimpleDateFormat("yyyy-MM-dd")
                .format(formDTO.getBirthday());
        form.setBirthday(formatDateString);
        if (formDTO.getGender().equalsIgnoreCase(String.valueOf(Gender.FEMALE))) {
            form.setGender(Gender.FEMALE);
        }
        if ((formDTO.getGender().equalsIgnoreCase(String.valueOf(Gender.MALE)))) {
            form.setGender(Gender.MALE);
        }
        List<String> professions = new ArrayList<>();
        professions.add(formDTO.getProfession());
        form.setProfession(professions);
        return form;
    }

}
