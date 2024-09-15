package ru.ekorzunov.urfu_bach_prog_3.lr2.service;

import ru.ekorzunov.urfu_bach_prog_3.lr2.exception.UnsupportedCodeException;
import ru.ekorzunov.urfu_bach_prog_3.lr2.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Objects;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
        if (Objects.equals(bindingResult.getFieldValue("uid"), "123")) {
            throw new UnsupportedCodeException("Этот uid запрещён.");
        }
    }
}
