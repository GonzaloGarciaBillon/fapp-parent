package cl.fapp.repository.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "emisor_actividad")
@NamedQuery(name = "EmisorActividad.findAll", query = "SELECT e FROM EmisorActividad e")
public class EmisorActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emisor_actividad", unique = true, nullable = false)
    private Long idEmisorActividad;

    @ManyToOne
    @JoinColumn(name = "rutemisor")
    private Emisores emisor;

    @ManyToOne
    @JoinColumn(name = "id_actividad_economica")
    private ActividadEconomica actividadEconomica;
}
