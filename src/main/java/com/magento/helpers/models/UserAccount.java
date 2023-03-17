package com.magento.helpers.models;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * file packageco.com.demo.magento.helpers.models
 */
@Getter
@Setter
@ToString
public class UserAccount {
    private String firstName;
    private String lastName;
    private String signUpForNewsletter;
    private String email;
    private String password;


    public void setDataUser() {
        Faker fakerDate = new Faker();
        firstName = fakerDate.name().firstName();
        lastName = fakerDate.name().lastName();
        email = fakerDate.internet().emailAddress();
        password = fakerDate.internet().password(8, 15, true, true);
    }

    public List<String> getAccountDataList() {
        return Arrays.asList(
                firstName,
                lastName,
                email
        );
    }

}
