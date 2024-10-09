package cl.fapp.repository.model;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bpos_detalle_historial")
@NamedQuery(name = "BposDetalleHistorial.findAll", query = "SELECT b FROM BposDetalleHistorial b")
public class BposDetalleHistorial {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_historial", unique = true, nullable = false)
    private Long idDetalleHistorial;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "rut_firmante")
    private String rutFirmante;

    @Column(name = "folio_dte")
    private Long folioDte;

    @Column(name = "monto")
    private BigInteger monto;

    @Column(name = "uuid")
    private String dteUuid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedat;

    @ManyToOne
    @JoinColumn(name = "id_historial_bpos")
    private BposHistorial bposHistorial;

    @ManyToOne
    @JoinColumn(name = "id_sucursal_bpos")
    private BposSucursal bposSucursal;

}
