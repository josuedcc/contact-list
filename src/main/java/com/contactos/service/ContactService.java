package com.contactos.service;

import java.util.List;

import com.contactos.models.Contacto;

public interface ContactService {
	List<Contacto> getAllContacts();
    Contacto getContactById(int id);
    Contacto updateContact(Contacto contact);
    void deleteContact(int id);
    Contacto createContact(Contacto contact);
}
