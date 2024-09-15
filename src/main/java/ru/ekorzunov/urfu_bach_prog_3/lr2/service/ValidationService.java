package ru.ekorzunov.urfu_bach_prog_3.lr2.service;

import ru.ekorzunov.urfu_bach_prog_3.lr2.exception.UnsupportedCodeException;
import ru.ekorzunov.urfu_bach_prog_3.lr2.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;
}
