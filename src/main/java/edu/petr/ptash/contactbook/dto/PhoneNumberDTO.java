package edu.petr.ptash.contactbook.dto;

import edu.petr.ptash.contactbook.entities.PhoneNumber;

public class PhoneNumberDTO {
    public final Long id;
    public final String operatorName;
    public final String number;

    public PhoneNumberDTO(Long id, String operatorName, String number) {
        this.id = id;
        this.operatorName = operatorName;
        this.number = number;
    }

    public static PhoneNumberDTO fromEntity(PhoneNumber phoneNumber) {
        return new PhoneNumberDTO(phoneNumber.getId(), phoneNumber.getOperatorName(), phoneNumber.getNumber());
    }
}
