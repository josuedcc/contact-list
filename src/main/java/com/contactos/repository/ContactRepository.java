package com.contactos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactos.models.Contacto;

@Repository
public interface ContactRepository extends JpaRepository<Contacto, Integer> {
}
