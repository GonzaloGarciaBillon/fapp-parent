package cl.fapp.repository.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sub_rubro")
@NamedQuery(name = "SubRubro.findAll", query = "SELECT s FROM SubRubro s")
public class SubRubro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_rubro", unique = true, nullable = false)
    private Long idSubRubro;

    @Column(name = "sub_rubro", nullable = false)
    private String subRubro;

    @ManyToOne
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;
    
    @JsonIgnore
    @OneToMany(mappedBy = "subRubro")
    private List<ActividadEconomica> actividadesEconomicas; 
}
