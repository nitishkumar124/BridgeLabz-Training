package com.example.contactapp.service.impl;

import com.example.contactapp.dto.ContactRequest;
import com.example.contactapp.dto.ContactResponse;
import com.example.contactapp.entity.Contact;
import com.example.contactapp.mapper.ContactMapper;
import com.example.contactapp.repository.ContactRepository;
import com.example.contactapp.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public ContactResponse createContact(ContactRequest request) {

        if (contactRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException(
                    "Contact with email " + request.getEmail() + " already exists"
            );
        } else if (contactRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new RuntimeException(
                    "Contact with phone " + request.getPhone() + " already exists"
            );
        }

        Contact entity = contactMapper.toEntity(request);
        Contact savedContact = contactRepository.save(entity);

        return contactMapper.toResponse(savedContact);
    }

    @Override
    public ContactResponse getContactById(Long contactId) {

        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Contact with id " + contactId + " does not exist"
                        )
                );

        return contactMapper.toResponse(contact);
    }

    @Override
    public List<ContactResponse> getAllContacts() {

        return contactRepository.findAll()
                .stream()
                .map(contactMapper::toResponse)
                .toList();
    }

    @Override
    public ContactResponse updateContact(
            Long contactId,
            ContactRequest request) {

        Contact existing = contactRepository.findById(contactId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Contact not found with id: " + contactId
                        )
                );

        Contact updatedContact = updateContactFields(existing, request);

        Contact updated = contactRepository.save(updatedContact);

        return contactMapper.toResponse(updated);
    }

    @Override
    public String deleteContact(Long contactId) {

        if (!contactRepository.existsById(contactId)) {
            throw new RuntimeException(
                    "Contact with id " + contactId + " does not exist"
            );
        }

        contactRepository.deleteById(contactId);

        return "Contact with id " + contactId + " has been deleted";
    }

    @Override
    public ContactResponse patchContact(
            Long contactId,
            ContactRequest request) {

        Contact existing = contactRepository.findById(contactId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Contact not found with id: " + contactId
                        )
                );

        if (request.getFirstName() != null) {
            existing.setFirstName(request.getFirstName());
        }

        if (request.getLastName() != null) {
            existing.setLastName(request.getLastName());
        }

        if (request.getEmail() != null) {

            if (!request.getEmail().equals(existing.getEmail())
                    && contactRepository.existsByEmail(request.getEmail())) {

                throw new RuntimeException(
                        "Contact with email " + request.getEmail()
                                + " already exists"
                );
            }

            existing.setEmail(request.getEmail());
        }

        if (request.getPhone() != null) {
            existing.setPhone(request.getPhone());
        }

        if (request.getAddress() != null) {
            existing.setAddress(request.getAddress());
        }

        if (request.getCity() != null) {
            existing.setCity(request.getCity());
        }

        if (request.getState() != null) {
            existing.setState(request.getState());
        }

        if (request.getCountry() != null) {
            existing.setCountry(request.getCountry());
        }

        Contact updated = contactRepository.save(existing);

        return contactMapper.toResponse(updated);
    }

    private Contact updateContactFields(
            Contact existing,
            ContactRequest request) {

        existing.setFirstName(request.getFirstName());
        existing.setLastName(request.getLastName());
        existing.setEmail(request.getEmail());
        existing.setPhone(request.getPhone());
        existing.setAddress(request.getAddress());
        existing.setCity(request.getCity());
        existing.setState(request.getState());
        existing.setCountry(request.getCountry());

        return existing;
    }
}