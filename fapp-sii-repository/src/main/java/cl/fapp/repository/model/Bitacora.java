package cl.fapp.repository.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bitacora")
@NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b")
public class Bitacora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bitacora", unique = true, nullable = false)
    private Long idBitacora;

    @Column(name = "estado")
    private String estado;

    @Column(name = "proceso")
    private String proceso;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "id_modelo")
    private String idModelo;

    @Column(name = "detalle")
    private String detalle;
}
