package com.example.apicar.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_cores")
public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O Campo cor é obrigatório")
    private String cor;

    @JsonIgnore
    @ManyToMany(mappedBy = "cores", fetch = FetchType.LAZY)
    private List<Carro> carros = new ArrayList<>();
}