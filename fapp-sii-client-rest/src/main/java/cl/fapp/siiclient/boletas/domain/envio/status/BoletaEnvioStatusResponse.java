package cl.fapp.siiclient.boletas.domain.envio.status;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class BoletaEnvioStatusResponse {
    /*
  "rut_emisor": "45000054-K",
  "rut_envia": "8315495-0",
  "trackid": 1014,
  "fecha_recepcion": "30/07/2020 07:57:42",
  "estado": "EPR",
  "estadistica": [
    {
      "tipo": 39,
      "informados": 3,
      "aceptados": 2,
      "rechazados": 1,
      "reparos": 0
    },
    {
      "tipo": 41,
      "informados": 1,
      "aceptados": 0,
      "rechazados": 0,
      "reparos": 1
    }
  ],
  "detalle_rep_rech": [
    {
      "tipo": 39,
      "folio": 1202,
      "estado": "RCH",
      "descripcion": "Dte Rechazado",
      "error": [
        {
          "seccion": "CRT",
          "linea": 155,
          "nivel": 3,
          "codigo": 11,
          "descripcion": "RUT envia diferente al Upload",
          "detalle": "[155]LSX-00291 value 0.52 is not declared"
        },
        {
          "seccion": "HED",
          "linea": 222,
          "nivel": 3,
          "codigo": 100,
          "descripcion": "Valor Detalle Distinto a Precio * Cantidad",
          "detalle": "[83154495-0] <> [9145888-K]"
        }
      ]
    },
    {
      "folio": 3500,
      "estado": "RPR",
      "descripcion": "Dte Aceptado con reparos",
      "error": [
        {
          "seccion": "DET",
          "linea": 2,
          "nivel": 1,
          "codigo": 200,
          "descripcion": "Valor Detalle Distinto a Precio * Cantidad",
          "detalle": "[2500 <> 3500]"
        }
      ]
    }
  ]
}*/

  String rut_emisor;
  String rut_envia;
  Integer trackid;
  String fecha_recepcion;
  String estado;

  List<Estadistica> estadistica;
  @JsonProperty("detalle_rep_rech")
  List<Detalle> detalle;


}
