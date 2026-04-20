package com.example.NEOAPP.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NEOAPP.modelos.MetodoPago;
import com.example.NEOAPP.repositorios.IMetodoPagoRepositorio;

@Service
public class MetodoPagoServicio {

    @Autowired
    private IMetodoPagoRepositorio repositorio;

    public MetodoPago guardar_metodoPago(MetodoPago metodoPago){
        if(metodoPago.getNombre() == null || metodoPago.getNombre().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del metodo de pago es obligatorio");
        }
        return repositorio.save(metodoPago);
    }

    public List<MetodoPago> listar_metodosPago(){
        return repositorio.findAll();
    }

}
