package com.digitazon.PhoneBook.model.services.implementations;

import com.digitazon.PhoneBook.model.entities.Contact;
import com.digitazon.PhoneBook.model.repositories.ContactRepository;
import com.digitazon.PhoneBook.model.services.abstractions.AbstractContactServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServices implements AbstractContactServices {

    private ContactRepository contactRepo;

    public ContactServices(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public List<Contact> findContactByLastNameLike(String like) {
        return contactRepo.findContactByLastNameLike("%" + like + "%");
    }
}
