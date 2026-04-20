package com.example.NEOAPP.modelos;

import java.time.LocalDate;
import java.util.List;

import com.example.NEOAPP.modelos.utils.Icono;
import com.example.NEOAPP.modelos.utils.TipoMovimiento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "Gastos")
public class Gasto {


    //id,descripcion,fecha,valor,icono
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Descripcion", nullable = false, unique = false, length = 100)
    private String descripcion;

    @Column(name = "Fecha", nullable = false, unique = false)
    private LocalDate fecha;

    @Column(name = "Valor", nullable = false, unique = false, precision = 10, scale = 2)
    private Double valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "Icono", nullable = true, unique = false, length = 50)           
    private Icono  iconos;


    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @Column(name = "Lugar", nullable = true, unique = false, length = 100)
    private String lugar;

    @Enumerated(EnumType.STRING)
    @Column(name = "TipoMovimiento", nullable = true, unique = false)
    private TipoMovimiento tipoMovimientos;


    @Column(name = "Observaciones", nullable = true, unique = false, length = 200)  
    private String observaciones;

    @Column(name = "UsuarioRegistro", nullable = true, unique = false, length = 50)
    private String usuarioRegistro;

    // relacion con tabla de usuario
    //1 gasto asociado a 1 solo usuario
    @ManyToOne
    @JoinColumn(name = "fk_usuario" , referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "gasto")
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "gasto")
    private List<Comercio> comercio;

    public Gasto() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Icono getIconos() {
        return iconos;
    }

    public void setIconos(Icono iconos) {
        this.iconos = iconos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public TipoMovimiento getTipoMovimientos() {
        return tipoMovimientos;
    }

    public void setTipoMovimientos(TipoMovimiento tipoMovimientos) {
        this.tipoMovimientos = tipoMovimientos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Comercio> getComercio() {
        return comercio;
    }

    public void setComercio(List<Comercio> comercio) {
        this.comercio = comercio;
    }
}
