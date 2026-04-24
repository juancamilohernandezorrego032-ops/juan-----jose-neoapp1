package com.example.NEOAPP.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NEOAPP.modelos.Categoria;
import com.example.NEOAPP.repositorios.ICategoriaRepositorio;

@Service
public class CategoriaServicio {

    @Autowired
    private ICategoriaRepositorio repositorio;

    // servicio para guardar una categoria
    public Categoria guardar_categoria(Categoria datosCategoria){

        // validar la operacion que me estan pidiendo hacer
        if(datosCategoria.getNombre() == null || datosCategoria.getNombre().isBlank() || datosCategoria.getNombre().isEmpty()){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre de la categoría es obligatorio, revisa por favor"
            );

        }

        if(datosCategoria.getNombre().length() < 3){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "el nombre de la categoría es invalido"
            );
        }

        // Despues de las validaciones intento guardar los datos que me enviaron
        return repositorio.save(datosCategoria);
        
    }

    // servicio para listar todas las categorias en BD
    public List<Categoria> listar_categorias(){
        return repositorio.findAll();
    }

    // servicio para eliminar una categoria en bd 

    // servicio para modificar una categoria en bd

    // servicio para buscar una categoria por su id

}