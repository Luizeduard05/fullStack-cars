package com.example.apicar.repositories;

import com.example.apicar.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    Marca findByNome(String nome);
}
