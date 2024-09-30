package com.example.springboot_supabase_crud.controller;

import com.example.springboot_supabase_crud.model.Estado;
import com.example.springboot_supabase_crud.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> getAllEstados() {
        return estadoService.getAllEstados();
    }

    @GetMapping("/{id}")
    public Estado getEstadoById(@PathVariable UUID id) {
        return estadoService.getEstadoById(id);
    }

    @PostMapping
    public Estado createEstado(@RequestBody Estado estado) {
        return estadoService.createEstado(estado);
    }

    @PutMapping("/{id}")
    public Estado updateEstado(@PathVariable UUID id, @RequestBody Estado estadoDetails) {
        return estadoService.updateEstado(id, estadoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEstado(@PathVariable UUID id) {
        estadoService.deleteEstado(id);
    }
}
