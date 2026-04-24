package com.example.NEOAPP.modelos;


import com.example.NEOAPP.modelos.utils.EstadoEmpresas;
import com.example.NEOAPP.modelos.utils.TipoEmpresas;

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
@Table(name = "Comercios")
public class Comercio {

    //id,nit,nombre,actividad,contacto(correo)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nit", nullable = false, unique = true, length = 20)
    private String nit;

    @Column(name = "Nombre", nullable = false, unique = false, length = 100)
    private String nombre;

    @Column(name = "Actividad", nullable = false, unique = false, length = 100)
    private String actividad;

    @Column(name = "Contacto", nullable = false, unique = false, length = 100)
    private String contacto;

    @Column(name = "RepresentanteLegal", nullable = false, unique = false, length = 100)
    private String representanteLegal;

    @Enumerated(EnumType.STRING)
    @Column(name = "TipoEmpresa", nullable = false, unique = false, length = 50)
    private TipoEmpresas tipoEmpresa;


    @Column(name = "SectorEconomico", nullable = false, unique = false, length = 100)
    private String sectorEconomico;

    @Column(name = "FechaRegistro", nullable = false, unique = false, length = 20)
    private String fechaRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoEmpresa", nullable = false, unique = false, length = 20)
    private EstadoEmpresas estadoEmpresa;




    @ManyToOne
    @JoinColumn(name = "fk_gasto" , referencedColumnName = "id")
    private Gasto gasto;
    
    public Comercio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public TipoEmpresas getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresas tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getSectorEconomico() {
        return sectorEconomico;
    }

    public void setSectorEconomico(String sectorEconomico) {
        this.sectorEconomico = sectorEconomico;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoEmpresas getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(EstadoEmpresas estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }
    
}
