package com.raiko.project.myCafe.validators;

import com.raiko.project.myCafe.dtos.ContactDTO;

import com.raiko.project.myCafe.models.Contact;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContactValidator implements Validator {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PHONE_PATTERN = "(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?";

    @Override
    public boolean supports(Class<?> clazz) {
        return Contact.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContactDTO contactDTO = (ContactDTO) target;

        if (contactDTO.getContactType().equals("Email")) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(contactDTO.getName());
            if (!matcher.matches()) {
                errors.rejectValue("name", "DIFFERENT", "не верный Email");
            }
        } if (contactDTO.getContactType().equals("Phone")) {
            Pattern pattern = Pattern.compile(PHONE_PATTERN);
            Matcher matcher = pattern.matcher(contactDTO.getName());
            if (!matcher.matches()) {
                errors.rejectValue("name", "DIFFERENT", "не верный номер");
            }
        } if (contactDTO.getContactType().equals("Viber")) {
            Pattern pattern = Pattern.compile(PHONE_PATTERN);
            Matcher matcher = pattern.matcher(contactDTO.getName());
            if (!matcher.matches()) {
                errors.rejectValue("name", "DIFFERENT", "не верный номер");
            }
        } if (contactDTO.getContactType().equals("Telegram")) {
            Pattern pattern = Pattern.compile(PHONE_PATTERN);
            Matcher matcher = pattern.matcher(contactDTO.getName());
            if (!matcher.matches()) {
                errors.rejectValue("name", "DIFFERENT", "не верный номер");
            }
        }
    }
}
