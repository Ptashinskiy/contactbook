package edu.petr.ptash.contactbook.services;


import edu.petr.ptash.contactbook.entities.Contact;
import edu.petr.ptash.contactbook.entities.PhoneNumber;

import java.util.List;

public interface ContactService {

    Contact findById(Long id);

    List<Contact> getAllContacts();

    Contact createNewContact(Contact contact);

    Contact updateContact(Contact contact);

    Contact addPhoneNumber(PhoneNumber number, Long id);

}
