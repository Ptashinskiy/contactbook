package edu.petr.ptash.contactbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CreateContactBody {

    @NotBlank
    public final String firstName;

    @NotBlank
    public final String lastName;

    @Email
    @NotBlank
    public final String email;

    public CreateContactBody(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
