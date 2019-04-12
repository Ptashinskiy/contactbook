package edu.petr.ptash.contactbook.services;

import edu.petr.ptash.contactbook.entities.Contact;
import edu.petr.ptash.contactbook.entities.ContactRepository;
import edu.petr.ptash.contactbook.entities.PhoneNumber;
import edu.petr.ptash.contactbook.entities.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImplementation implements ContactService {


    private final ContactRepository contactRepository;
    private final PhoneNumberServiceImplementation numberService;

    @Autowired
    public ContactServiceImplementation(ContactRepository contactRepository, PhoneNumberServiceImplementation numberService) {
        this.contactRepository = contactRepository;
        this.numberService = numberService;
    }

    @Override
    public Contact findById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAllJoinNumbers();
    }

    @Override
    public Contact createNewContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact addPhoneNumber(PhoneNumber number, Long id) {
        Contact contact = findById(id);
        contact.getPhoneNumbers().add(number);
        return contactRepository.save(contact);
    }
}
