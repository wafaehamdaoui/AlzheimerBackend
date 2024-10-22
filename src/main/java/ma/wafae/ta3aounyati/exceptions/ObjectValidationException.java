package ma.wafae.ta3aounyati.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Set;

public class ObjectValidationException extends ExceptionAbstract{
    public ObjectValidationException(String errorMessages) {
        super(HttpStatus.BAD_REQUEST, errorMessages, 400);
    }

}
