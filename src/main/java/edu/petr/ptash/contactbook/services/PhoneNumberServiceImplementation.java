package edu.petr.ptash.contactbook.services;

import edu.petr.ptash.contactbook.entities.PhoneNumber;
import edu.petr.ptash.contactbook.entities.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberServiceImplementation implements PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public PhoneNumberServiceImplementation(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public PhoneNumber findById(Long id) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(id);
        return phoneNumber.orElseThrow(RuntimeException::new);
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public PhoneNumber addNewPhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }
}
