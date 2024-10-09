package cl.fapp.repository.model;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bpos_historial")
@NamedQuery(name = "BposHistorial.findAll", query = "SELECT b FROM BposHistorial b")
public class BposHistorial {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_bpos", unique = true, nullable = false)
    private Long idHistorialBPOS;

    @Column(name = "cantidad_dtes", nullable = false)
    private Integer cantidadDtes;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    Date createDat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    Date updateDat;

    @OneToMany(mappedBy = "bposHistorial")
    private List<BposDetalleHistorial> bposDetalleHistorials;

    @ManyToOne
    @JoinColumn(name = "rutemisor")
    private Emisores emisor;

    @ManyToOne
    @JoinColumn(name = "id_sucursal_bpos")
    private BposSucursal bposSucursal;

}
