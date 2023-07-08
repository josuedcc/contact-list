package com.contactos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactos.models.Contacto;
import com.contactos.repository.ContactRepository;


@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactRepository contactRepository;

	@Override
    public List<Contacto> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contacto getContactById(int id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contacto updateContact(Contacto contact) {
    	System.out.println(contact);
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contacto createContact(Contacto contact) {
        return contactRepository.save(contact);
    }

}
