package com.example.springboot_supabase_crud.service;

import com.example.springboot_supabase_crud.model.Persona;
import com.example.springboot_supabase_crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Transactional
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @Transactional
    public Persona getPersonaById(UUID id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Transactional
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional
    public Persona updatePersona(UUID id, Persona personaActualizada) {
        Persona personaExistente = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        // Actualizar los campos necesarios
        personaExistente.setNombre(personaActualizada.getNombre());
        personaExistente.setApellido(personaActualizada.getApellido());
        personaExistente.setPais(personaActualizada.getPais());
        personaExistente.setEstado(personaActualizada.getEstado());

        return personaRepository.save(personaExistente);
    }

    @Transactional
    public void deletePersona(UUID id) {
        personaRepository.deleteById(id);
    }
}
