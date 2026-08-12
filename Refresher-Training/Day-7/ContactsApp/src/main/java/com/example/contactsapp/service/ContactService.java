package com.example.contactsapp.service;

import com.example.contactsapp.dao.ContactDAO;
import com.example.contactsapp.dto.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactDAO contactDAO;

    public ContactService(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public List<Contact> getAllContacts() {
        return contactDAO.findAll();
    }

    public Contact getContactById(int id) {
        return contactDAO.findById(id);
    }

    public Contact createContact(Contact contact) {
        return contactDAO.save(contact);
    }
}