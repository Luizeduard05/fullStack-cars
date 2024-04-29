package com.example.apicar.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_marcas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O Campo nome é obrigatório")
    private String nome;

    @JsonBackReference
    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("marca")
    private List<Carro> carros = new ArrayList<>();

}