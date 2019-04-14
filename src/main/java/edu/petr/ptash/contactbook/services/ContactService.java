package edu.petr.ptash.contactbook.services;

import edu.petr.ptash.contactbook.entities.Contact;
import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();

    Contact createNewContact(String firstname, String lastName, String email);

    void updateContact(Long id, String firstName, String lastName, String email);

}
