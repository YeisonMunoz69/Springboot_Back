package com.example.springboot_supabase_crud.controller;

import com.example.springboot_supabase_crud.model.Pais;
import com.example.springboot_supabase_crud.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin(origins = "http://localhost:4200")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> getAllPaises() {
        return paisService.getAllPaises();
    }

    @GetMapping("/{id}")
    public Pais getPaisById(@PathVariable UUID id) {
        return paisService.getPaisById(id);
    }

    @PostMapping
    public Pais createPais(@RequestBody Pais pais) {
        return paisService.createPais(pais);
    }

    @PutMapping("/{id}")
    public Pais updatePais(@PathVariable UUID id, @RequestBody Pais paisDetails) {
        return paisService.updatePais(id, paisDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePais(@PathVariable UUID id) {
        paisService.deletePais(id);
    }
}
