package com.example.springboot_supabase_crud.controller;

import com.example.springboot_supabase_crud.model.Persona;
import com.example.springboot_supabase_crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    // Obtener todas las personas
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    // Obtener persona por ID
    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable UUID id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada"));
    }

    // Crear nueva persona
    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    // Actualizar persona por ID
    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable UUID id, @RequestBody Persona personaDetails) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada"));

        persona.setNombre(personaDetails.getNombre());
        persona.setApellido(personaDetails.getApellido());
        persona.setPais(personaDetails.getPais());
        persona.setEstado(personaDetails.getEstado());
        return personaRepository.save(persona);
    }

    // Eliminar persona por ID
    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable UUID id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada"));
        personaRepository.delete(persona);
    }
}
