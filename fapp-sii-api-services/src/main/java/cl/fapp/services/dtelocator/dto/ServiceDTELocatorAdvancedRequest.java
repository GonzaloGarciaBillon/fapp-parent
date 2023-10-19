package cl.fapp.services.dtelocator.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Extiende el request simple para localizar un DTE
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ServiceDTELocatorAdvancedRequest extends ServiceDTELocatorSimpleRequest {
	private String signatureValue;
}
