package edu.petr.ptash.contactbook.controllers;

import edu.petr.ptash.contactbook.entities.Contact;
import edu.petr.ptash.contactbook.entities.ContactRepository;
import edu.petr.ptash.contactbook.entities.PhoneNumber;
import edu.petr.ptash.contactbook.entities.PhoneNumberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
public class MainController {


    private final ContactRepository contactRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    public MainController(ContactRepository contactRepository, PhoneNumberRepository phoneNumberRepository) {
        this.contactRepository = contactRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @GetMapping("/")
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }
}
