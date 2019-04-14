package edu.petr.ptash.contactbook.dto;

import edu.petr.ptash.contactbook.entities.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class ContactDTO {
    public final Long id;
    public final String firstName;
    public final String lastName;
    public final String email;

    public final List<PhoneNumberDTO> numbers;

    public ContactDTO(Long id, String firstName, String lastName, String email, List<PhoneNumberDTO> numbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numbers = numbers;
    }

    public static ContactDTO fromEntity(Contact contact) {
        List<PhoneNumberDTO> numberDTOS = contact.getPhoneNumbers().stream().map(PhoneNumberDTO::fromEntity).collect(Collectors.toList());
        return new ContactDTO(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(), numberDTOS);
    }
}
