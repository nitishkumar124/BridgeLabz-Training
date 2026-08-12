package com.example.contactsapp.controller;

import com.example.contactsapp.dto.Contact;
import com.example.contactsapp.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {

        List<Contact> contacts = contactService.getAllContacts();

        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {

        Contact contact = contactService.getContactById(id);

        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(
            @Valid @RequestBody Contact contact) {

        Contact savedContact = contactService.createContact(contact);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedContact);
    }
}