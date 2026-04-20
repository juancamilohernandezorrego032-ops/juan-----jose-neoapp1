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

    public Categoria guardar_categoria(Categoria categoria){
        if(categoria.getNombre() == null || categoria.getNombre().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de la categoria es obligatorio");
        }
        return repositorio.save(categoria);
    }

    public List<Categoria> listar_categorias(){
        return repositorio.findAll();
    }

}
