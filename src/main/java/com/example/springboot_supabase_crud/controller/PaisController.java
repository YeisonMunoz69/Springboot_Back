package com.example.springboot_supabase_crud.controller;

import com.example.springboot_supabase_crud.model.Pais;
import com.example.springboot_supabase_crud.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    // Obtener todos los países
    @GetMapping
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    // Obtener país por ID
    @GetMapping("/{id}")
    public Pais getPaisById(@PathVariable UUID id) {
        return paisRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País no encontrado"));
    }

    // Crear nuevo país
    @PostMapping
    public Pais createPais(@RequestBody Pais pais) {
        return paisRepository.save(pais);
    }

    // Actualizar país por ID
    @PutMapping("/{id}")
    public Pais updatePais(@PathVariable UUID id, @RequestBody Pais paisDetails) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País no encontrado"));

        pais.setNombre(paisDetails.getNombre());
        return paisRepository.save(pais);
    }

    // Eliminar país por ID
    @DeleteMapping("/{id}")
    public void deletePais(@PathVariable UUID id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País no encontrado"));
        paisRepository.delete(pais);
    }
}
