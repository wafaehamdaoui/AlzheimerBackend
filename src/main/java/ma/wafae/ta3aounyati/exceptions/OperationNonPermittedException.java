package ma.wafae.ta3aounyati.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public class OperationNonPermittedException extends ExceptionAbstract {

    public OperationNonPermittedException(String message) {
        super(HttpStatus.FORBIDDEN, message, 403);
    }
}
