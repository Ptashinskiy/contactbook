package edu.petr.ptash.contactbook.services;

import edu.petr.ptash.contactbook.entities.Contact;
import edu.petr.ptash.contactbook.entities.ContactRepository;
import edu.petr.ptash.contactbook.entities.PhoneNumber;
import edu.petr.ptash.contactbook.entities.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneNumberServiceImplementation implements PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public PhoneNumberServiceImplementation(PhoneNumberRepository phoneNumberRepository, ContactRepository contactRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional
    public PhoneNumber addNewPhoneNumber(PhoneNumber phoneNumber, Long contactId) {
        if (contactRepository.existsById(contactId)) {
            Contact contact = contactRepository.getOne(contactId);
            phoneNumber.setContact(contact);
            return phoneNumberRepository.save(phoneNumber);
        }
        throw new EntityNotFound(contactId);
    }

    @Override
    @Transactional
    public void updatePhoneNumber(Long id, String operatorName, String number) {
        if (phoneNumberRepository.existsById(id)) {
            phoneNumberRepository.updatePhoneNumberById(id, operatorName, number);
        } else throw new EntityNotFound(id);
    }

}
