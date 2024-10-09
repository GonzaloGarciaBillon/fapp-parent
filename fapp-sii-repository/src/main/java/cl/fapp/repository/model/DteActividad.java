package cl.fapp.repository.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dte_actividad")
@NamedQuery(name = "DteActividad.findAll", query = "SELECT d FROM DteActividad d")
public class DteActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dte_actividad", unique = true, nullable = false)
    private Long idDteActividad;

    @ManyToOne
    @JoinColumn(name = "idDte")
    private Dte dte;

    @ManyToOne
    @JoinColumn(name = "id_actividad_economica")
    private ActividadEconomica actividadEconomica;
}