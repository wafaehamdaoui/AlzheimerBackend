package ma.wafae.ta3aounyati.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
public class ResourceNotFound extends ExceptionAbstract {

    public ResourceNotFound(String message) {
        super(HttpStatus.NOT_FOUND, message, 404);
    }
}
