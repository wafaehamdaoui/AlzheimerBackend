package ma.wafae.ta3aounyati.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistsException extends ExceptionAbstract {
    public ResourceAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message, 409);
    }
}
