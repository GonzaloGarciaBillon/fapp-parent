package cl.fapp.domain.validator;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = TipoDocumentoSubsetValidator.class)
public @interface TipoDocumentoSubset {
	ConstantesTipoDocumento[] anyOf();

	String message() default "debe ser cualquiera de {anyOf}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
