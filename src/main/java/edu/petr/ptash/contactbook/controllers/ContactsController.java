package edu.petr.ptash.contactbook.controllers;

import edu.petr.ptash.contactbook.dto.*;
import edu.petr.ptash.contactbook.entities.Contact;
import edu.petr.ptash.contactbook.entities.PhoneNumber;
import edu.petr.ptash.contactbook.services.ContactService;
import edu.petr.ptash.contactbook.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping(value = "/contacts")
public class ContactsController {

    private final ContactService contactService;

    @Autowired
    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<ContactsList> getContacts() {
        List<ContactDTO> allContacts = contactService.getAllContacts()
                .stream()
                .map(ContactDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ContactsList(allContacts));
    }

    @PostMapping
    public ResponseEntity<Contact> createNewContact(@Valid @RequestBody CreateContactBody contactBody) {
        return ResponseEntity.ok(contactService.createNewContact(contactBody.firstName, contactBody.lastName, contactBody.email));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateContact(@Valid @RequestBody UpdateContactBody contactBody, @Min(1) @PathVariable("id") Long id) {
        contactService.updateContact(id, contactBody.firstName, contactBody.lastName, contactBody.email);
        return ResponseEntity.ok().build();
    }

}
