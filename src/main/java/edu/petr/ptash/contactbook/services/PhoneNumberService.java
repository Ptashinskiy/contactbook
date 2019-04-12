package edu.petr.ptash.contactbook.services;

import edu.petr.ptash.contactbook.entities.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {

    PhoneNumber findById(Long id);

    List<PhoneNumber> getAllPhoneNumbers();

    PhoneNumber addNewPhoneNumber(PhoneNumber phoneNumber);

    PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber);
}
