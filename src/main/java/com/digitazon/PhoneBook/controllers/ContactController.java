package com.digitazon.PhoneBook.controllers;

import com.digitazon.PhoneBook.model.entities.Category;
import com.digitazon.PhoneBook.model.entities.Contact;
import com.digitazon.PhoneBook.model.repositories.CategoryRepository;
import com.digitazon.PhoneBook.model.repositories.ContactRepository;
import com.digitazon.PhoneBook.model.services.abstractions.AbstractContactServices;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "*")
public class ContactController {
    private ContactRepository contactRepo;
    private CategoryRepository categoryRepo;
    private AbstractContactServices contactServices;

    public ContactController(ContactRepository contactRepo, CategoryRepository categoryRepo,
                             AbstractContactServices contactServices) {
        this.contactRepo = contactRepo;
        this.categoryRepo = categoryRepo;
        this.contactServices = contactServices;
    }

    @GetMapping("/")
    public Iterable<Contact> showAllContacts() {
        Iterable<Contact> contacts = contactRepo.findAll(Sort.by(Sort.Direction.DESC, "favorites"));
        return contacts;
    }

    @GetMapping
    public ResponseEntity getByLastNameLike(@RequestParam String like) {
        if (like.isEmpty()) {
            return ResponseEntity.badRequest().body("il parametro like deve essere settato");
        }
        var contacts = contactServices.findContactByLastNameLike(like);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {
       return contactRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Contact create(@RequestBody Contact newContact) {
        Contact savedContact = contactRepo.save(newContact);
        if (savedContact.getPhoneNumber().isEmpty() && savedContact.getLastName().isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            Category category = categoryRepo.findById(savedContact.getCategory().getId()).orElseThrow();
            savedContact.setCategory(category);
        }
        return savedContact;
    }

    @PutMapping("/update")
    public Contact update(@RequestBody Contact updatedContact) throws Exception {
        Contact contact = contactRepo.findById(updatedContact.getId()).orElseThrow();
        contact.setFirstName(updatedContact.getFirstName());
        contact.setLastName(updatedContact.getLastName());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        return contactRepo.save(contact);
    }

    @PutMapping("/favorites/{id}")
    public Contact markAsFavorites(@PathVariable int id) {
        Contact contact = contactRepo.findById(id).orElseThrow();
        contact.setFavorites(!contact.isFavorites());
        return contactRepo.save(contact);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        contactRepo.deleteById(id);
        return "ok";
    }
}