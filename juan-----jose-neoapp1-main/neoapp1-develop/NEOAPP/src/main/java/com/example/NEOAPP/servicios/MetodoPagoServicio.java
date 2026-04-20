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

  
    public MetodoPago guardar_metodoPago(MetodoPago datosMetodoPago){

  
        if(datosMetodoPago.getNombre() == null || 
           datosMetodoPago.getNombre().isBlank() || 
           datosMetodoPago.getNombre().isEmpty()){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del método de pago es obligatorio"
            );
        }

       
        return repositorio.save(datosMetodoPago);
    }

    
    public List<MetodoPago> listar_metodosPago(){
        return repositorio.findAll();
    }

   
    public void eliminar_metodoPago(Integer id){
        if(!repositorio.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Método de pago no encontrado"
            );
        }
        repositorio.deleteById(id);
    }

    public MetodoPago buscar_metodoPagoPorId(Integer id){
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Método de pago no encontrado"
            ));
    }

    
    public MetodoPago modificar_metodoPago(Integer id, MetodoPago datosActualizados){

        MetodoPago metodoExistente = buscar_metodoPagoPorId(id);

        if(datosActualizados.getNombre() == null || 
           datosActualizados.getNombre().isBlank()){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del método de pago es obligatorio"
            );
        }

        metodoExistente.setNombre(datosActualizados.getNombre());

        return repositorio.save(metodoExistente);
    }
}
