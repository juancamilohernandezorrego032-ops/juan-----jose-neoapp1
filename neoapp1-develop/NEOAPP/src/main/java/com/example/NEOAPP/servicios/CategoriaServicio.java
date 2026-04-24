
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

        // validaciones
        if(datosCategoria.getNombre() == null || datosCategoria.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre de la categoría es obligatorio"
            );
        }

        if(datosCategoria.getDescripcion() != null && datosCategoria.getDescripcion().length() < 5){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La descripción debe tener al menos 5 caracteres"
            );
        }

        // guardar en BD
        return repositorio.save(datosCategoria);
    }

    // servicio para listar categorias
    public List<Categoria> listar_categorias(){
        return repositorio.findAll();
    }

    // servicio para buscar por id
    public Categoria buscar_categoria_por_id(Integer id){
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Categoría no encontrada"
            ));
    }

    // servicio para eliminar
    public void eliminar_categoria(Integer id){
        Categoria categoria = buscar_categoria_por_id(id);
        repositorio.delete(categoria);
    }

    // servicio para editar
    public Categoria editar_categoria(Integer id, Categoria datosNuevos){

        Categoria categoriaExistente = buscar_categoria_por_id(id);

        if(datosNuevos.getNombre() != null && !datosNuevos.getNombre().isBlank()){
            categoriaExistente.setNombre(datosNuevos.getNombre());
        }

        if(datosNuevos.getDescripcion() != null){
            categoriaExistente.setDescripcion(datosNuevos.getDescripcion());
        }

        return repositorio.save(categoriaExistente);
    }
}