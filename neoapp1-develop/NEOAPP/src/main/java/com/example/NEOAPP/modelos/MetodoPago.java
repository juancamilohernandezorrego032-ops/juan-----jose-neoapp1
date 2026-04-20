package com.example.NEOAPP.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MetodosdePago")
public class MetodoPago {

    //id, nombre, franquicia, estado(activo/inactivo)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre", nullable = false, unique = false, length = 50)
    private String nombre;

    @Column(name = "Franquicia", nullable = false, unique = false, length = 50)
    private String franquicia;

    @Column(name = "Estado", nullable = false, unique = false)
    private Boolean estado;

    @Column(name = "Descripcion", nullable = true, unique = false, length = 100)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "fk_usuario" , referencedColumnName = "id")
    private Usuario usuario;

    public MetodoPago() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFranquicia() {
        return franquicia;
    }
    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
