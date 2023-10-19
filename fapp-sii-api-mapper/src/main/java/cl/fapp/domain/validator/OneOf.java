package cl.fapp.domain.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {OneOfIntegerValidator.class, OneOfStringValidator.class})
public @interface OneOf {
	String message() default "debe ser uno de los siguientes: ";
	
	String attribute() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int[] intValues() default {};

	String[] strValues() default {};

}
