package com.example.NEOAPP.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NEOAPP.modelos.MetodoPago;

@Repository
public interface IMetodoPagoRepositorio extends JpaRepository<MetodoPago, Integer> {

    // Espacio para consultas personalizadas sobre Metodos de Pago

}
