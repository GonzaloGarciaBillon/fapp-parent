package cl.fapp.repository.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bpos_sucursal")
@NamedQuery(name = "BposSucursal.findAll", query = "SELECT b FROM BposSucursal b")
public class BposSucursal {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal_bpos", unique = true, nullable = false)
    private Long idSucursalBPOS;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "serie_bpos")
    private String serieBpos;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedat;

    @ManyToOne
    @JoinColumn(name = "rutemisor")
    private Emisores emisor;

    @OneToMany(mappedBy = "bposSucursal")
    private List<BposHistorial> bposHistorial;

    @OneToMany(mappedBy = "bposSucursal")
    private List<BposDetalleHistorial> bposDetalleHistorial;

}
