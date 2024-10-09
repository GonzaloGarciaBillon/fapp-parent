package cl.fapp.repository.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rubro")
@NamedQuery(name = "Rubro.findAll", query = "SELECT r FROM Rubro r")
public class Rubro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rubro", unique = true, nullable = false)
    private Long idRubro;

    @Column(name = "rubro", nullable = false)
    private String rubro;

    @JsonIgnore
    @OneToMany(mappedBy = "rubro")
    private List<SubRubro> SubRubros;
}
