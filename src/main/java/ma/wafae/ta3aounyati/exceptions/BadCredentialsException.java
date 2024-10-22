package ma.wafae.ta3aounyati.exceptions;

import org.springframework.http.HttpStatus;

public class BadCredentialsException extends ExceptionAbstract {
    public BadCredentialsException(String message) {
        super(HttpStatus.UNAUTHORIZED, message, 401);
    }
}
