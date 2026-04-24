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
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El NIT es obligatorio"
            );
        }

        if(comercio.getNombre() == null || comercio.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es obligatorio"
            );
        }

        if(comercio.getActividad() == null || comercio.getActividad().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La actividad es obligatoria"
            );
        }

        if(comercio.getContacto() == null || comercio.getContacto().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El contacto es obligatorio"
            );
        }

        if(comercio.getRepresentanteLegal() == null || comercio.getRepresentanteLegal().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El representante legal es obligatorio"
            );
        }

        if(comercio.getTipoEmpresa() == null){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El tipo de empresa es obligatorio"
            );
        }

        if(comercio.getSectorEconomico() == null || comercio.getSectorEconomico().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El sector económico es obligatorio"
            );
        }

        if(comercio.getFechaRegistro() == null || comercio.getFechaRegistro().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La fecha de registro es obligatoria"
            );
        }

        if(comercio.getEstadoEmpresa() == null){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El estado de la empresa es obligatorio"
            );
        }

        return repositorio.save(comercio);
    }

    
    public List<Comercio> listar_comercios(){
        return repositorio.findAll();
    }

    
    public Comercio buscar_comercio(Integer id){
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Comercio no encontrado"
            ));
    }

    
    public void eliminar_comercio(Integer id){
        if(!repositorio.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Comercio no encontrado"
            );
        }
        repositorio.deleteById(id);
    }

    
    public Comercio actualizar_comercio(Integer id, Comercio datos){

        Comercio comercio = buscar_comercio(id);

        if(datos.getNombre() == null || datos.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es obligatorio"
            );
        }

        if(datos.getActividad() == null || datos.getActividad().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La actividad es obligatoria"
            );
        }

        comercio.setNombre(datos.getNombre());
        comercio.setActividad(datos.getActividad());
        comercio.setContacto(datos.getContacto());
        comercio.setSectorEconomico(datos.getSectorEconomico());
        comercio.setEstadoEmpresa(datos.getEstadoEmpresa());

        return repositorio.save(comercio);
    }
}