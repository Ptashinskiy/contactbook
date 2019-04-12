package edu.petr.ptash.contactbook.controllers;

import edu.petr.ptash.contactbook.dto.CreateContactBody;
import edu.petr.ptash.contactbook.dto.CreatePhoneNumberBody;
import edu.petr.ptash.contactbook.dto.UpdateContactBody;
import edu.petr.ptash.contactbook.dto.UpdatePhoneNumberBody;
import edu.petr.ptash.contactbook.entities.Contact;
import edu.petr.ptash.contactbook.entities.PhoneNumber;
import edu.petr.ptash.contactbook.services.ContactService;
import edu.petr.ptash.contactbook.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
public class MainController {

    private final ContactService contactService;
    private final PhoneNumberService numberService;

    @Autowired
    public MainController(ContactService contactService, PhoneNumberService numberService) {
        this.contactService = contactService;
        this.numberService = numberService;
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping
    public void createNewContact(@RequestBody CreateContactBody contactBody) {
        contactService.createNewContact(new Contact(contactBody.getFirstName(), contactBody.getLastName(), contactBody.getEmail()));
    }

    @PatchMapping("/{id}")
    public Contact updateContact(@RequestBody UpdateContactBody contactBody, @PathVariable("id") Long id) {
        Contact contact = contactService.findById(id);
        contact.setFirstName(contactBody.getFirstName());
        contact.setLastName(contactBody.getLastName());
        contact.setEmail(contactBody.getEmail());
        return contactService.updateContact(contact);
    }

    @PostMapping("/{id}/numbers")
    public Contact addNewPhoneNumber(@RequestBody CreatePhoneNumberBody numberBody, @PathVariable Long id) {
        PhoneNumber number = new PhoneNumber(numberBody.getOperatorName(), numberBody.getNumber());
        numberService.addNewPhoneNumber(number);
        return contactService.addPhoneNumber(number, id);
    }

    @PatchMapping("/{id}/numbers/{number_id}")
    public void updatePhoneNumber(@RequestBody UpdatePhoneNumberBody numberBody, @PathVariable Long id, @PathVariable Long number_id) {
        PhoneNumber number = numberService.findById(number_id);
        number.setOperatorName(numberBody.getOperatorName());
        number.setNumber(numberBody.getNumber());
        numberService.updatePhoneNumber(number);
    }
}
