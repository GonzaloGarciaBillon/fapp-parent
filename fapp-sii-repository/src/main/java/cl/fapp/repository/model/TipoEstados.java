package cl.fapp.repository.model;

import javax.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_estados")
@NamedQuery(name = "TipoEstados.findAll", query = "SELECT t FROM TipoEstados t")
public class TipoEstados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_ESTADO")
    private Long idTipoEstado;

    @Column(name = "NOMBRE_TIPO_ESTADO")
    private String nombreTipoEstado;

    @OneToMany(mappedBy = "tipoEstado")
    @JsonIgnore
    private List<Estados> estadosList;
}
