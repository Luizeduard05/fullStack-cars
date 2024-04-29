package com.example.apicar.repositories;

import com.example.apicar.models.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorRepository extends JpaRepository<Cor, Integer> {
    Cor findByCor(String cor);
}
