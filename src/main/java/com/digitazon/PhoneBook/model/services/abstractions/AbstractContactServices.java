package com.digitazon.PhoneBook.model.services.abstractions;

import com.digitazon.PhoneBook.model.entities.Contact;

import java.util.List;
import java.util.Optional;

public interface AbstractContactServices {

    List<Contact> findContactByLastNameLike(String like);
}
