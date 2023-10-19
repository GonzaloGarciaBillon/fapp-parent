package cl.fapp.repository.repos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.agg.IAggCertificateExpiryDate;
import cl.fapp.repository.model.KeystoreFirmantes;

@Repository
@RepositoryRestResource(exported = false)
public interface KeystoreFirmantesRepository extends JpaRepository<KeystoreFirmantes, Long> {

	boolean existsByFirmanteIdFirmante(Long idFirmante);

	Optional<KeystoreFirmantes> findByFirmanteIdFirmante(Long idFirmante);

	Optional<List<KeystoreFirmantes>> findByCertificateExpiryDateLessThanEqual(Date fecha);

	/**
	 * Busca certificados que esten proximos a expirar
	 * 
	 * @param fechaExpiracion fecha de expiracion minima
	 * @return lista de keystore que cumplen la condicion de busqueda
	 */
	// @formatter:off
	@Query(value="select kf.id_keystore as idKeystore, \n"
			+ "       f.rutfirmante as rutFirmante, \n"
			+ "       f.rutemisor as rutEmisor,\n"
			+ "       e.razon_social as razonSocial,\n"
			+ "       kf.certificate_expiry_date as expiryDate\n"
			+ "  from firmantes f, emisores e, keystore_firmantes kf\n"
    		+ " left join support_ticket tk on ( tk.ticket_type = :ticketType and tk.ref_entity = :refEntity and tk.ref_entity_id = kf.id_keystore)"
			+ " where kf.id_firmante = f.id_firmante\n"
			+ "   and f.rutemisor = e.rutemisor\n"
			+ "   and kf.certificate_expiry_date <= :fechaExpiracion\n"
			+ "   and tk.ticket_value is null", nativeQuery=true)
	Optional<List<IAggCertificateExpiryDate>> reportCertificateExpiryDate(
    		@Param("ticketType")String ticketType,
    		@Param("refEntity")String refEntity,
    		@Param("fechaExpiracion")Date fechaExpiracion);
	// @formatter:on

}