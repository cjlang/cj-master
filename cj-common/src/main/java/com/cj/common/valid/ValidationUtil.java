package com.cj.common.valid;
import com.cj.common.exception.CJException;
import org.hibernate.validator.HibernateValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

public class ValidationUtil {

    private static Validator validator = Validation
            .byProvider(HibernateValidator.class)
            .configure()
            .failFast(false)
            .buildValidatorFactory()
            .getValidator();

    public static void validate(Object bean) {
        Set<ConstraintViolation<Object>> validate = validator.validate(bean);
        if(!validate.isEmpty())
        {
            String errorMsg="";
            Iterator<ConstraintViolation<Object>> it = validate.iterator();
            for (; it.hasNext(); ) {
                ConstraintViolation<Object> next = it.next();
                errorMsg+= ","+next.getMessage();
            }
            throw new CJException(-1,errorMsg);
        }
    }
}