package com.example.NEOAPP.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NEOAPP.modelos.Gasto;
import com.example.NEOAPP.repositorios.IGastoRepositorio;

@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio repositorio;

    public Gasto guardar_gasto(Gasto gasto){
        if(gasto.getDescripcion() == null || gasto.getDescripcion().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La descripcion del gasto es obligatoria");
        }
        return repositorio.save(gasto);
    }

    public List<Gasto> listar_gastos(){
        return repositorio.findAll();
    }

}
