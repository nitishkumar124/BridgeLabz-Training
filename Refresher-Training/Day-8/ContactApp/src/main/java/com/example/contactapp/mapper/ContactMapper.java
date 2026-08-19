package com.example.contactapp.mapper;

import com.example.contactapp.dto.ContactRequest;
import com.example.contactapp.dto.ContactResponse;
import com.example.contactapp.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public Contact toEntity(ContactRequest request) {
        Contact contact = new Contact();

        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contact.setAddress(request.getAddress());
        contact.setCity(request.getCity());
        contact.setState(request.getState());
        contact.setCountry(request.getCountry());

        return contact;
    }

    public ContactResponse toResponse(Contact contact) {
        return ContactResponse.builder()
                .contactId(contact.getContactId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .address(contact.getAddress())
                .city(contact.getCity())
                .state(contact.getState())
                .country(contact.getCountry())
                .createdAt(contact.getCreatedAt())
                .updatedAt(contact.getUpdatedAt())
                .build();
    }
}