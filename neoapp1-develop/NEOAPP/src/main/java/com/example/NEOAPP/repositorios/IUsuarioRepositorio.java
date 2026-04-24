package com.example.NEOAPP.repositorios;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NEOAPP.modelos.Usuario;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {

    //buscar por nombre exacto (lista)
    List<Usuario> findByNombres(String nombres);
    //buscar por documento (1)
    //Optional<Usuario> findByDocumento(String documento);

    //buscar por nombres que contengan nnn (lista)
    List<Usuario> findByNombresContaining(String nombres);

    //buscar por edad (lista)
    List<Usuario> findByEdad(Integer edad);


}
