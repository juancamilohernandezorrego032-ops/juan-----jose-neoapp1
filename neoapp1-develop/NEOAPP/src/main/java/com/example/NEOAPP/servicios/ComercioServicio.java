package com.example.NEOAPP.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NEOAPP.modelos.Comercio;
import com.example.NEOAPP.repositorios.IComercioRepositorio;

@Service
public class ComercioServicio {

    @Autowired
    private IComercioRepositorio repositorio;

    public Comercio guardar_comercio(Comercio comercio){
        if(comercio.getNit() == null || comercio.getNit().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El NIT del comercio es obligatorio");
        }
        return repositorio.save(comercio);
    }

    public List<Comercio> listar_comercios(){
        return repositorio.findAll();
    }

}
