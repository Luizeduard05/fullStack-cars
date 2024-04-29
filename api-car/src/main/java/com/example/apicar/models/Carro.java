package com.example.apicar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O Campo nome_carro é obrigatório")
    private String nome_carro;

    @NotNull(message = "O Campo ano_fabricacao é obrigatório")
    private Integer ano_fabricacao;

    @NotNull(message = "O Campo ano_modelo é obrigatório")
    private Integer ano_modelo;

    @NotBlank(message = "O Campo modelo_carro é obrigatório")
    private String modelo_carro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "carro_cor",
            joinColumns = @JoinColumn(name = "id_carro"),
            inverseJoinColumns = @JoinColumn(name = "id_cor"))
    private List<Cor> cores = new ArrayList<>();
}
