package com.example.NEOAPP.modelos;

import java.time.LocalDate;

import com.example.NEOAPP.modelos.utils.Estados;
import com.example.NEOAPP.modelos.utils.Prioridades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "Categorias")
public class Categoria {

    //id,nombre,fechaCreacion,responsable,justificacion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nombre", nullable = false, unique = false, length = 50)
    private String nombre;

    @Column(name = "FechaCreacion", nullable = false, unique = false)
    private LocalDate fechaCreacion;

    @Column(name = "Responsable", nullable = false, unique = false, length = 50)
    private String responsable;

    @Column(name = "Justificacion", nullable = true, unique = false, length = 200)
    private String justificacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = false, unique = false, length = 20)
    private Estados estado;


    @Column(name = "FechaFinalizacion", nullable = true, unique = false)
    private LocalDate fechaFinalizacion;

    @Column(name = "Presupuesto", nullable = true, unique = false)
    private Double presupuesto;

    @Enumerated(EnumType.STRING)
    @Column(name = "Prioridad", nullable = false, unique = false, length = 20)
    private Prioridades prioridad;


    @Column(name = "AreaSolicitante", nullable = false, unique = false, length = 50)
    private String areaSolicitante;


    @ManyToOne
    @JoinColumn(name = "fk_gasto" , referencedColumnName = "id")
    private Gasto gasto;
    
    public Categoria() {
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Prioridades getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridades prioridad) {
        this.prioridad = prioridad;
    }

    public String getAreaSolicitante() {
        return areaSolicitante;
    }

    public void setAreaSolicitante(String areaSolicitante) {
        this.areaSolicitante = areaSolicitante;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }
    
    
    
}
