package cl.fapp.repository.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "actividad_economica")
@NamedQuery(name = "ActividadEconomica.findAll", query = "SELECT a FROM ActividadEconomica a")
public class ActividadEconomica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad_economica", unique = true, nullable = false)
    private Long idActividadEconomica;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "actividad", nullable = false)
    private String actividad;

    @Column(name = "afecta_iva", nullable = false)
    private String afectaIva;

    @Column(name = "categoria_tributaria", nullable = false)
    private String categoriaTributaria;

    @Column(name = "disponible_internet", nullable = false)
    private Boolean disponibleInternet;

    @ManyToOne
    @JoinColumn(name = "id_sub_rubro")
    private SubRubro subRubro;

    @JsonIgnore
    @OneToMany(mappedBy = "actividadEconomica")
    private List<EmisorActividad> emisorActividades;

    @JsonIgnore
    @OneToMany(mappedBy = "actividadEconomica")
    private List<DteActividad> dteActividades;
}
