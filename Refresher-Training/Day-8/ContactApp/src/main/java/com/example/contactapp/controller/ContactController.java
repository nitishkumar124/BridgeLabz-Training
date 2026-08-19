package com.example.contactapp.controller;

import com.example.contactapp.dto.ContactRequest;
import com.example.contactapp.dto.ContactResponse;
import com.example.contactapp.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/create")
    public ResponseEntity<ContactResponse> addContact(
            @RequestBody ContactRequest request) {

        return new ResponseEntity<>(
                contactService.createContact(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactResponse> getContactById(
            @PathVariable Long contactId) {

        return new ResponseEntity<>(
                contactService.getContactById(contactId),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAllContacts() {

        return new ResponseEntity<>(
                contactService.getAllContacts(),
                HttpStatus.OK
        );
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactResponse> updateContact(
            @PathVariable Long contactId,
            @RequestBody ContactRequest request) {

        return new ResponseEntity<>(
                contactService.updateContact(contactId, request),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContact(
            @PathVariable Long contactId) {

        return new ResponseEntity<>(
                contactService.deleteContact(contactId),
                HttpStatus.OK
        );
    }

    @PatchMapping("/{contactId}")
    public ResponseEntity<ContactResponse> patchContact(
            @PathVariable Long contactId,
            @RequestBody ContactRequest request) {

        return new ResponseEntity<>(
                contactService.patchContact(contactId, request),
                HttpStatus.OK
        );
    }
}