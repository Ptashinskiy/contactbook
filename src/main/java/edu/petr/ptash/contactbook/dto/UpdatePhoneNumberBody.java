package edu.petr.ptash.contactbook.dto;

import javax.validation.constraints.NotBlank;

public class UpdatePhoneNumberBody {

    @NotBlank
    public final String operatorName;

    @NotBlank
    public final String number;

    public UpdatePhoneNumberBody(String operatorName, String number) {
        this.operatorName = operatorName;
        this.number = number;
    }

}
