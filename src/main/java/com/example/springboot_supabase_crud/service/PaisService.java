package com.example.springboot_supabase_crud.service;

import com.example.springboot_supabase_crud.model.Pais;
import com.example.springboot_supabase_crud.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Transactional
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    @Transactional
    public Pais getPaisById(UUID id) {
        return paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
    }

    @Transactional
    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Transactional
    public Pais updatePais(UUID id, Pais paisDetails) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));

        pais.setNombre(paisDetails.getNombre());
        return paisRepository.save(pais);
    }

    @Transactional
    public void deletePais(UUID id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
        paisRepository.delete(pais);
    }
}
