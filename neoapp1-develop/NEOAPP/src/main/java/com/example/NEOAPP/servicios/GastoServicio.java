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
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La descripción del gasto es obligatoria"
            );
        }

        if(gasto.getValor() == null || gasto.getValor() <= 0){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El valor debe ser mayor a 0"
            );
        }

        return repositorio.save(gasto);
    }

    
    public List<Gasto> listar_gastos(){
        return repositorio.findAll();
    }

    
    public Gasto buscar_gasto(Integer id){
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Gasto no encontrado"
            ));
    }


    public void eliminar_gasto(Integer id){
        if(!repositorio.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Gasto no encontrado"
            );
        }
        repositorio.deleteById(id);
    }

    
    public Gasto actualizar_gasto(Integer id, Gasto datos){

        Gasto gasto = buscar_gasto(id);

        if(datos.getDescripcion() == null || datos.getDescripcion().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La descripción del gasto es obligatoria"
            );
        }

        if(datos.getValor() == null || datos.getValor() <= 0){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El valor debe ser mayor a 0"
            );
        }

        gasto.setDescripcion(datos.getDescripcion());
        gasto.setValor(datos.getValor());

        return repositorio.save(gasto);
    }
}