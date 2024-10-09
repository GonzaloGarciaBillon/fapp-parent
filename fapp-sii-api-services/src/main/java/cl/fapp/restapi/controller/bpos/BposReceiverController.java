package cl.fapp.restapi.controller.bpos;

import cl.fapp.restapi.controller.bpos.dto.BposReceiverRequest;
import cl.fapp.restapi.controller.bpos.dto.BposReceiverResponse;
import cl.fapp.repository.repos.*;
import cl.fapp.repository.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("${fapp.api.controller.base-path}/bpos")
public class BposReceiverController {

    private static final Logger log = LoggerFactory.getLogger(BposReceiverController.class);

    @Autowired
    private BposSucursalRepository bposSucursalRepository;

    @Autowired
    private BposHistorialRepository bposHistorialRepository;

    @Autowired
    private BposDetalleHistorialRepository bposDetalleHistorialRepository;

    @Autowired
    private DteRepository dteRepository;

    @Autowired
    private EmisoresRepository repoEmisores;

    @PostMapping("/dteReceiver")
    @Transactional
    public ResponseEntity<BposReceiverResponse> dteReceiver(@RequestBody BposReceiverRequest request) {
        BposReceiverResponse response = new BposReceiverResponse();
        List<BposReceiverResponse.DteStatus> dtesProcesados = new ArrayList<>();
        List<BposReceiverResponse.DteStatus> dtesNoProcesados = new ArrayList<>();

        int totalDtes = request.getDtes().size();
        int countProcesados = 0;
        int countNoProcesados = 0;

        try {
            Optional<Emisores> emisorOpt = findEmisorByRut(request.getRutEmisor());
            if (emisorOpt.isEmpty()) {
                response.setStatus("ERROR");
                response.setMessage("Emisor no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            Emisores emisor = emisorOpt.get();

            String estadoSucursal = "ACTIVA";

            Optional<BposSucursal> sucursal = bposSucursalRepository.findBySerieBpos(request.getSerieBpos());
			if (!sucursal.isPresent()) {
				log.error("La sucursal con id={} no existe en la base de datos", request.getSerieBpos());
				response.setMessage("La sucursal no existe en la base de datos");
				return ResponseEntity.badRequest().body(response);
			}
            

            // Crear y guardar BposHistorial
            BposHistorial bposHistorial = new BposHistorial();
            bposHistorial.setCantidadDtes(totalDtes);
            bposHistorial.setEstado("PROCESADO");
            bposHistorial.setCreateDat(new Date());
            bposHistorial.setUpdateDat(new Date());
            bposHistorial.setEmisor(emisor);
            bposHistorial.setBposSucursal(sucursal.get());
            BposHistorial savedHistorial = bposHistorialRepository.save(bposHistorial);

            // Procesar cada DTE en el request
            for (BposReceiverRequest.DteDto dteDto : request.getDtes()) {
                try {
                    List<Dte> dtes = dteRepository.findByFolioAsignadoAndEmisoreRutemisorAndTipoDocumento(
                        dteDto.getFolioAsignado(), 
                        request.getRutEmisor(), 
                        dteDto.getTipoDocumento()
                    );
                    
                    if (!dtes.isEmpty()) {
                        BposReceiverResponse.DteStatus dteStatus = new BposReceiverResponse.DteStatus(
                            dteDto.getFolioAsignado(), 
                            "DTE ya existe", 
                            dteDto.getTipoDocumento(), 
                            dteDto.getMonto()
                        );
                        dtesNoProcesados.add(dteStatus);
                        countNoProcesados++;
                        continue;  // Skip to the next DTE
                    }

                    // Crear y guardar BposDetalleHistorial
                    BposDetalleHistorial detalleHistorial = new BposDetalleHistorial();
                    detalleHistorial.setEstado("PROCESADO");
                    detalleHistorial.setRutFirmante(dteDto.getRutFirmante());
                    detalleHistorial.setFolioDte(dteDto.getFolioAsignado());
                    detalleHistorial.setMonto(dteDto.getMonto());
                    detalleHistorial.setDteUuid(dteDto.getDteUuid());
                    detalleHistorial.setCreatedat(new Date());
                    detalleHistorial.setUpdatedat(new Date());
                    detalleHistorial.setBposHistorial(savedHistorial);
                    detalleHistorial.setBposSucursal(sucursal.get());
                    bposDetalleHistorialRepository.save(detalleHistorial);

                    // Crear y guardar Dte
                    Dte dte = new Dte();
                    dte.setCreatedat(new Date());
                    dte.setDocumentoXml(dteDto.getDocumentoXml());
                    dte.setDteUuid(dteDto.getDteUuid());
                    dte.setEstado("CREADOFIRMADO");
                    dte.setFolioAsignado(dteDto.getFolioAsignado());
                    dte.setIdDocumento(dteDto.getIdDocumento());
                    dte.setMonto(dteDto.getMonto());
                    dte.setRutfirmante(dteDto.getRutFirmante());
                    dte.setTipoDocumento(dteDto.getTipoDocumento());
                    dte.setUpdatedat(new Date());
                    dte.setSignatureValue(dteDto.getSignatureValue());
                    dte.setEmisore(emisor);
                    dteRepository.save(dte);

                    BposReceiverResponse.DteStatus dteStatus = new BposReceiverResponse.DteStatus(
                        dteDto.getFolioAsignado(), 
                        "PROCESADO", 
                        dteDto.getTipoDocumento(), 
                        dteDto.getMonto()
                    );
                    dtesProcesados.add(dteStatus);
                    countProcesados++;

                } catch (Exception e) {
                    BposReceiverResponse.DteStatus dteStatus = new BposReceiverResponse.DteStatus(
                        dteDto.getFolioAsignado(), 
                        "ERROR: " + e.getMessage(), 
                        dteDto.getTipoDocumento(), 
                        dteDto.getMonto()
                    );
                    dtesNoProcesados.add(dteStatus);
                    countNoProcesados++;
                }
            }

            response.setStatus("success");
            response.setMessage("DTEs procesados con detalle");
            response.setTotalDtes(totalDtes);
            response.setCantidadProcesados(countProcesados);
            response.setCantidadNoProcesados(countNoProcesados);
            response.setDtesProcesados(dtesProcesados);
            response.setDtesNoProcesados(dtesNoProcesados);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("Error al procesar los DTEs");
            response.setStatus("ERROR: " + e.getMessage());
            response.setTotalDtes(totalDtes);
            response.setCantidadProcesados(countProcesados);
            response.setCantidadNoProcesados(countNoProcesados);
            response.setDtesNoProcesados(dtesNoProcesados);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Optional<Emisores> findEmisorByRut(String rutEmisor) {
        return repoEmisores.findById(rutEmisor);
    }
}
