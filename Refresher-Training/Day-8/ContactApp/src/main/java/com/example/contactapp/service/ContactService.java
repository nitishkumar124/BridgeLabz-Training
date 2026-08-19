package com.example.contactapp.service;

import com.example.contactapp.dto.ContactRequest;
import com.example.contactapp.dto.ContactResponse;

import java.util.List;

public interface ContactService {

    ContactResponse createContact(ContactRequest request);

    ContactResponse getContactById(Long contactId);

    List<ContactResponse> getAllContacts();

    ContactResponse updateContact(Long contactId, ContactRequest request);

    String deleteContact(Long contactId);

    ContactResponse patchContact(Long contactId, ContactRequest request);
}