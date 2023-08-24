package com.raiko.project.myCafe.dtos;

import javax.validation.constraints.Size;

public class ContactDTO {
    private String contactType;


    @Size(min = 5, max = 20)
    private String name;

    public ContactDTO() {
    }

    public ContactDTO(String contactType, String name) {
        this.contactType = contactType;
        this.name = name;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
