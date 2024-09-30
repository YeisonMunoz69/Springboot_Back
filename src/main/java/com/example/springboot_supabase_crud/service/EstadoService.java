package com.example.springboot_supabase_crud.service;

import com.example.springboot_supabase_crud.model.Estado;
import com.example.springboot_supabase_crud.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    @Transactional
    public Estado getEstadoById(UUID id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
    }

    @Transactional
    public Estado createEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Transactional
    public Estado updateEstado(UUID id, Estado estadoDetails) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        estado.setNombre(estadoDetails.getNombre());
        return estadoRepository.save(estado);
    }

    @Transactional
    public void deleteEstado(UUID id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        estadoRepository.delete(estado);
    }
}
