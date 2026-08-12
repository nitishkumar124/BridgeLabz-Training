package com.example.contactsapp.dao;

import com.example.contactsapp.dto.Contact;

import java.util.List;

public interface ContactDAO {

    List<Contact> findAll();

    Contact findById(int id);

    Contact save(Contact contact);
}