package ru.zaromskih.SpringBootFirstAppLr2.service;


import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.zaromskih.SpringBootFirstAppLr2.exception.ValidationFailedException;

@Service
public class ReguestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());
        }

    }

}
