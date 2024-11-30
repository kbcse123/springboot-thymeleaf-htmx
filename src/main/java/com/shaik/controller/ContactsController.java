package com.shaik.controller;

import com.shaik.model.Contact;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    List<Contact> contacts = List.of(
            new Contact("khader", "Basha", "kbcse123@gmail.com"),
            new Contact("Jeelani", "Begum", "jeelani@gmail.com"),
            new Contact("Aahira", "Begum", "aahi@gmail.com"),
            new Contact("Ashfiya", "Begum", "ashfi@gmail.com"),
            new Contact("Naseem", "Begum", "naseem@gmail.com"),
            new Contact("Rubina", "Begum", "rubi@gmail.com"),
            new Contact("Farhana", "Begum", "farha@gmail.com")

    );

    @GetMapping("/view")
    public String viewContacts(Model model) {
        model.addAttribute("contacts", contacts);
        return "viewContacts";
    }

    @GetMapping("/edit")
    public String editContact() {
        return "contactEdit";
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateContact(Contact contact, Model model) {
        System.out.println(contact);
        model.addAttribute("contact", contact);
        return "saved";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    //write test cases for search method
    @PostMapping("/searchContacts")
    public String searchContacts(String query,Model model) {
        //query =query.toLowerCase().trim();
        System.out.println("Search query =  "+query);
        List<Contact> matchedContacts = new ArrayList<>();
        if (query != null && !query.isEmpty()) {
            contacts.forEach(contact -> {
                if (contact.firstName().contains(query) ||
                        contact.lastName().contains(query) ||
                        contact.email().contains(query)) {
                    matchedContacts.add(contact);
                }
            });
        }
        model.addAttribute("matchedContacts", matchedContacts);
        return "result";
    }


}
