package edu.petr.ptash.contactbook.controllers;

import edu.petr.ptash.contactbook.dto.CreatePhoneNumberBody;
import edu.petr.ptash.contactbook.dto.PhoneNumberDTO;
import edu.petr.ptash.contactbook.dto.UpdatePhoneNumberBody;
import edu.petr.ptash.contactbook.entities.PhoneNumber;
import edu.petr.ptash.contactbook.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping(value = "/numbers")
public class NumberController {

    private final PhoneNumberService numberService;

    @Autowired
    public NumberController(PhoneNumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping
    public ResponseEntity<PhoneNumberDTO> addNewPhoneNumber(@Valid @RequestBody CreatePhoneNumberBody numberBody) {
        PhoneNumber number = numberService.addNewPhoneNumber(new PhoneNumber(numberBody.operatorName, numberBody.number), numberBody.contactId);
        return ResponseEntity.ok(PhoneNumberDTO.fromEntity(number));
    }

    @PatchMapping("/{numberId}")
    public ResponseEntity<Void> updatePhoneNumber(@Valid @RequestBody UpdatePhoneNumberBody numberBody, @Min(1) @PathVariable Long numberId) {
        numberService.updatePhoneNumber(numberId, numberBody.operatorName, numberBody.number);
        return ResponseEntity.ok().build();
    }

}
