package ru.zaromskih.SpringBootFirstAppLr2.contoller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zaromskih.SpringBootFirstAppLr2.exception.UnsupportedCodeException;
import ru.zaromskih.SpringBootFirstAppLr2.exception.ValidationFailedException;
import ru.zaromskih.SpringBootFirstAppLr2.model.Reguest;
import ru.zaromskih.SpringBootFirstAppLr2.model.Response;
import ru.zaromskih.SpringBootFirstAppLr2.service.ValidationService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MyController {

    private final ValidationService validationService;

    @Autowired
    public MyController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Reguest reguest, BindingResult bindingResult) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Response response = Response.builder()
                .uid(reguest.getUid())
                .operationUid(reguest.getOperationUid())
                .systemName(reguest.getSystemName())
                .systemTime(simpleDateFormat.format(new Date()))
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        try {
            validationService.isValid(bindingResult);
            if("123".equals(reguest.getUid())){ //поле uid 123
                throw new UnsupportedCodeException("123 простая комбинацию, введите более сложную.");
            }

        } catch (ValidationFailedException e) {
            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("Ошибка валидации.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (UnsupportedCodeException e){
            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("123 простая комбинацию, введите более сложную.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            response.setCode("failed");
            response.setErrorCode("UnknownException");
            response.setErrorMessage("Произошла непредвиденная ошибка.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}