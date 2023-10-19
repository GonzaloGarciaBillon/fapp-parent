package cl.fapp.domain.validator;

import static java.util.stream.Collectors.toSet;
import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OneOfStringValidator implements ConstraintValidator<OneOf, String> {
	private Set<String> allowedValues;
	private String userAttribute;
	private String userMessage;
    
	@Override
	public void initialize(OneOf constraintAnnotation) {
		allowedValues = Arrays.stream(constraintAnnotation.strValues()).collect(toSet());
		userAttribute = constraintAnnotation.attribute();
		userMessage = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();

		if( value == null || allowedValues.contains(value) ) {
			return true;
		}else {
			String themessage = userAttribute + " " + userMessage + allowedValues; //--> "El valor indicado debe ser uno de los siguientes: " + allowedValues;
			customMessageForValidation(context, themessage);
			return false;
			
		}
	}
	
    private void customMessageForValidation(ConstraintValidatorContext context, String message) {
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
