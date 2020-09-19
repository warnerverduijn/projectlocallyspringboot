package novi.spring.projectlocally.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppUserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler (AppUserNotFoundException.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public String appUserNotFoundHandler (AppUserNotFoundException ex) {
        return ex.getMessage();
    }


}
