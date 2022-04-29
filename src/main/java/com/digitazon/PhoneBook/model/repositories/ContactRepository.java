package com.digitazon.PhoneBook.model.repositories;

import com.digitazon.PhoneBook.model.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select c from Contact c where lower(c.lastName) like :like")
    List<Contact> findContactByLastNameLike(String like);
}
