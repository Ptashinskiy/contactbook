package edu.petr.ptash.contactbook.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreatePhoneNumberBody {

    @NotBlank
    public final String operatorName;

    @NotBlank
    public final String number;

    @NotNull @Min(1)
    public final Long contactId;

    public CreatePhoneNumberBody(String operatorName, String number, Long contactId) {
        this.operatorName = operatorName;
        this.number = number;
        this.contactId = contactId;
    }
}
