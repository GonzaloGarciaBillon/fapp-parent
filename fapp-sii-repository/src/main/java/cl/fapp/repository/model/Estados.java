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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estados")
@NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e")
public class Estados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO")
    private Long idEstado;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    private Date fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_ESTADO")
    private TipoEstados tipoEstado;

    @OneToMany(mappedBy = "estados")
    @JsonIgnore
    private List<Dte> dtesList;
}
