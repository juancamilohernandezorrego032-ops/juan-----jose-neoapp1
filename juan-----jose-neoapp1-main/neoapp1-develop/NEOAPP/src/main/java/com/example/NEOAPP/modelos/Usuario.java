package com.example.NEOAPP.modelos;

import java.util.List;

import com.example.NEOAPP.modelos.utils.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    //id,nombres,tipodoc,documento,edad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NombresCompletos",nullable = false, unique = false,length = 50)
    private String nombres;

    @Column( name = "Tipo_Documento",nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumentos;

    @Column(name = "documento", nullable = false, unique = true,length = 15)
    private String documento;

    @Column(name = "Edad", nullable = false, unique = false)
    private Integer edad;

    @Column(name = "Apellidos",nullable = false, unique = false,length = 50)
    private String apellidos;

    @Column(name = "Direccion",nullable = false, unique = false,length = 100)
    private String direccion;

    @Column(name = "Telefono",nullable = false, unique = false,length = 15)
    private String telefono;

    @Column(name = "Correo_Electronico",nullable = false, unique = true,length = 100)
    private String correoElectronico;

    @Column(name = "Ciudad",nullable = false, unique = false,length = 50)
    private String ciudad;

    //creando la primera relacion con la tabla gastos
    //un usuario muchos gastos

    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

    @OneToMany(mappedBy = "usuario")
    private List<MetodoPago> metodosPago;


    
    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public TipoDocumento getTipoDocumentos() {
        return tipoDocumentos;
    }

    public void setTipoDocumentos(TipoDocumento tipoDocumentos) {
        this.tipoDocumentos = tipoDocumentos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<MetodoPago> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(List<MetodoPago> metodosPago) {
        this.metodosPago = metodosPago;
    }


    
    

}
