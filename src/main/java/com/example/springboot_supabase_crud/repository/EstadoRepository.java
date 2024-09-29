package com.example.springboot_supabase_crud.repository;

import com.example.springboot_supabase_crud.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, UUID> {
    // Métodos adicionales si son necesarios
}
