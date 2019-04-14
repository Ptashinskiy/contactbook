package edu.petr.ptash.contactbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UpdateContactBody {

    @NotBlank
    public final String firstName;

    @NotBlank
    public final String lastName;

    @NotBlank @Email
    public final String email;

    public UpdateContactBody(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
