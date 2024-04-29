package com.example.apicar.services;


import com.example.apicar.models.Carro;
import com.example.apicar.models.Cor;
import com.example.apicar.models.Marca;
import com.example.apicar.repositories.CarroRepository;
import com.example.apicar.repositories.CorRepository;
import com.example.apicar.repositories.MarcaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarroService {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CorRepository corRepository;

    public ResponseEntity<List<Carro>> getAllCars() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Carro> addCar(Carro carro) {
        Marca marca = marcaRepository.findByNome(carro.getMarca().getNome());
        if (marca == null) {
            marca = new Marca();
            marca.setNome(carro.getMarca().getNome());
            marca = marcaRepository.save(marca);
        }

        List<Cor> coresSalvas = new ArrayList<>();
        for (Cor cor : carro.getCores()) {
            Cor corExistente = corRepository.findByCor(cor.getCor());
            if (corExistente == null) {
                corExistente = new Cor();
                corExistente.setCor(cor.getCor());
                corExistente = corRepository.save(corExistente);
            }
            coresSalvas.add(corExistente);
        }

        carro.setMarca(marca);
        carro.setCores(coresSalvas);
        return new ResponseEntity<>(repository.save(carro), HttpStatus.CREATED);
    }

    public ResponseEntity<Carro> editCar(Integer id, Carro carro) {
        Carro carroExistente = repository.findById(id).orElse(null);
        if (carroExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Marca marca = marcaRepository.findByNome(carro.getMarca().getNome());
        if (marca == null) {
            marca = new Marca();
            marca.setNome(carro.getMarca().getNome());
            marca = marcaRepository.save(marca);
        }

        List<Cor> coresSalvas = new ArrayList<>();
        for (Cor cor : carro.getCores()) {
            Cor corExistente = corRepository.findByCor(cor.getCor());
            if (corExistente == null) {
                corExistente = new Cor();
                corExistente.setCor(cor.getCor());
                corExistente = corRepository.save(corExistente);
            }
            coresSalvas.add(corExistente);
        }

        carroExistente.setNome_carro(carro.getNome_carro());
        carroExistente.setAno_fabricacao(carro.getAno_fabricacao());
        carroExistente.setAno_modelo(carro.getAno_modelo());
        carroExistente.setModelo_carro(carro.getModelo_carro());

        carroExistente.setMarca(marca);
        carroExistente.setCores(coresSalvas);

        return new ResponseEntity<>(repository.save(carroExistente), HttpStatus.OK);
    }

    public ResponseEntity<Optional<Carro>> deleteCar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
