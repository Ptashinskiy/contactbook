package edu.petr.ptash.contactbook.services;

import edu.petr.ptash.contactbook.entities.Contact;
import edu.petr.ptash.contactbook.entities.ContactRepository;
import edu.petr.ptash.contactbook.entities.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImplementation implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImplementation(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> getAllContacts() {
        return contactRepository.findAllJoinNumbers();
    }

    @Override
    @Transactional
    public Contact createNewContact(String firstname, String lastName, String email) {
        return contactRepository.save(new Contact(firstname, lastName, email));
    }

    @Override
    @Transactional
    public void updateContact(Long id, String firstName, String lastName, String email) {
        if (contactRepository.existsById(id)) {
            contactRepository.updateContactById(firstName, lastName, email, id);
        } else throw new EntityNotFound(id);
    }

}
