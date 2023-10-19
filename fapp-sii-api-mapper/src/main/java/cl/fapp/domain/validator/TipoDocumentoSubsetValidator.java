package cl.fapp.domain.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cl.fapp.common.domain.ConstantesTipoDocumento;

public class TipoDocumentoSubsetValidator implements ConstraintValidator<TipoDocumentoSubset, ConstantesTipoDocumento> {
	private ConstantesTipoDocumento[] subset;

	@Override
	public void initialize(TipoDocumentoSubset constraint) {
		this.subset = constraint.anyOf();
	}

	@Override
	public boolean isValid(ConstantesTipoDocumento value, ConstraintValidatorContext context) {
		return value == null || Arrays.asList(subset).contains(value);
	}
}
