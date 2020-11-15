package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validateR")
public class RValidator implements Validator {
    private static final double min = 1;
    private static final double max = 4;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        double y = Double.parseDouble(String.valueOf(value));
        if (y <= min || y >= max) {
            System.out.println(Double.parseDouble(String.valueOf(value)));
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "R должен лежать в промежутке(1; 4)!"));
        }
    }
}
