package com.contactos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.contactos.models.Contacto;
import com.contactos.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;

	@GetMapping("/")
	public String home(Model model) {
		List<Contacto> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "index";
	}
	
	@GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Contacto contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "edit";
    }

    @PostMapping("/update")
    public String updateContact(@ModelAttribute("contact") Contacto contact) {
        contactService.updateContact(contact);
        return "redirect:/";
    }
    
    @GetMapping("/create")
    public String showCreateForm(Model model) {
    	Contacto contact = new Contacto();
        model.addAttribute("contact", contact);
        return "create";
    }

    @PostMapping("/create")
    public String createContact(@ModelAttribute("contact") Contacto contact) {
    	System.out.println(contact);
        contactService.createContact(contact);
        return "redirect:/";
    }
    
    @GetMapping("/{id}/delete")
    public String showDeleteForm(@PathVariable("id") int id, Model model) {
    	Contacto contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteContact(@ModelAttribute("contact") Contacto contact) {
        contactService.deleteContact(contact.getId());
        return "redirect:/";
    }
	
}
