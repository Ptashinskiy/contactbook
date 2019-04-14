package edu.petr.ptash.contactbook.services;

import edu.petr.ptash.contactbook.entities.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {

    PhoneNumber addNewPhoneNumber(PhoneNumber phoneNumber, Long contactId);

    void updatePhoneNumber(Long id, String operatorName, String number);
}
