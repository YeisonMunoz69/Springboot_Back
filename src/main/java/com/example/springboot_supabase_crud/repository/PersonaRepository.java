package com.example.springboot_supabase_crud.repository;


import com.example.springboot_supabase_crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, UUID> {
    // Métodos adicionales si son necesarios
}

