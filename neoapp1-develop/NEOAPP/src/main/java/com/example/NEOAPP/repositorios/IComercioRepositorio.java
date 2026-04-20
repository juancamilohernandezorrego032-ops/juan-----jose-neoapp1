package com.example.NEOAPP.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NEOAPP.modelos.Comercio;

@Repository
public interface IComercioRepositorio extends JpaRepository<Comercio, Integer> {

    // Espacio para consultas personalizadas sobre Comercios

}
