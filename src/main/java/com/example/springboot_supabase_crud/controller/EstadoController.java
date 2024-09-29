package com.example.springboot_supabase_crud.controller;

import com.example.springboot_supabase_crud.model.Estado;
import com.example.springboot_supabase_crud.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    // Obtener todos los estados
    @GetMapping
    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    // Obtener estado por ID
    @GetMapping("/{id}")
    public Estado getEstadoById(@PathVariable UUID id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado no encontrado"));
    }

    // Crear nuevo estado
    @PostMapping
    public Estado createEstado(@RequestBody Estado estado) {
        return estadoRepository.save(estado);
    }

    // Actualizar estado por ID
    @PutMapping("/{id}")
    public Estado updateEstado(@PathVariable UUID id, @RequestBody Estado estadoDetails) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado no encontrado"));

        estado.setNombre(estadoDetails.getNombre());
        return estadoRepository.save(estado);
    }

    // Eliminar estado por ID
    @DeleteMapping("/{id}")
    public void deleteEstado(@PathVariable UUID id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado no encontrado"));
        estadoRepository.delete(estado);
    }
}
