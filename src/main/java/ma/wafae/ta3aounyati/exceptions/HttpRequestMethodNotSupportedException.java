package ma.wafae.ta3aounyati.exceptions;

import org.springframework.http.HttpStatus;

public class HttpRequestMethodNotSupportedException extends ExceptionAbstract{
    public HttpRequestMethodNotSupportedException() {
        super(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed", 405);
    }
}
