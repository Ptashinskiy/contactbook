package edu.petr.ptash.contactbook.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotFound extends RuntimeException {

    public EntityNotFound(Long id) {
        super("Entity with id " + id + " not found");
    }
}
