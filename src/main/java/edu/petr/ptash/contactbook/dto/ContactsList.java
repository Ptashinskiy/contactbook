package edu.petr.ptash.contactbook.dto;

import java.util.List;

public class ContactsList {
    public final List<ContactDTO> contacts;

    public ContactsList(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }
}
