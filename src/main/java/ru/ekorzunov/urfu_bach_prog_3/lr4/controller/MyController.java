package ru.ekorzunov.urfu_bach_prog_3.lr4.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import ru.ekorzunov.urfu_bach_prog_3.lr4.exception.UnsupportedCodeException;
import ru.ekorzunov.urfu_bach_prog_3.lr4.exception.ValidationFailedException;
import ru.ekorzunov.urfu_bach_prog_3.lr4.model.*;
import ru.ekorzunov.urfu_bach_prog_3.lr4.service.ModifyRequestService;
import ru.ekorzunov.urfu_bach_prog_3.lr4.service.ModifyResponseService;
import ru.ekorzunov.urfu_bach_prog_3.lr4.service.SendToSecondInstanceService;
import ru.ekorzunov.urfu_bach_prog_3.lr4.service.ValidationService;
import ru.ekorzunov.urfu_bach_prog_3.lr4.util.DateTimeUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RequestMapping("/lr4")
@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService1;
    private final ModifyResponseService modifyResponseService2;
    private final ModifyRequestService modifyRequestService1;
    private final ModifyRequestService modifyRequestService2;
    private final SendToSecondInstanceService sendToSecondInstanceService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService1,
                        @Qualifier("ModifyOperationUidResponseService") ModifyResponseService modifyResponseService2,
                        @Qualifier("ModifySystemNameRequestService") ModifyRequestService modifyRequestService1,
                        @Qualifier("ModifySourceRequestService") ModifyRequestService modifyRequestService2,
                        @Qualifier("SendToSecondInstanceService") SendToSecondInstanceService sendToSecondInstanceService) {
        this.validationService = validationService;
        this.modifyResponseService1 = modifyResponseService1;
        this.modifyResponseService2 = modifyResponseService2;
        this.modifyRequestService1 = modifyRequestService1;
        this.modifyRequestService2 = modifyRequestService2;
        this.sendToSecondInstanceService = sendToSecondInstanceService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("request: {}", request);

        Date requestDateTime = new Date();

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(requestDateTime))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        HttpStatus httpStatus = HttpStatus.OK;

        try {
            log.info("validation...");
            validationService.isValid(bindingResult);
            log.info("validation success");
        } catch (ValidationFailedException e) {
            log.error(e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            httpStatus = HttpStatus.BAD_REQUEST;
            log.info("validation failed");
        } catch (UnsupportedCodeException e) {
            log.error(e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            httpStatus = HttpStatus.BAD_REQUEST;
            log.info("validation failed");
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            log.info("validation failed");
        }
        response = modifyResponseService1.modify(response);
        response = modifyResponseService2.modify(response);
        log.info("response: {}", response);


        request = modifyRequestService1.modify(request);
        request = modifyRequestService2.modify(request);
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(requestDateTime));

        sendToSecondInstanceService.send(request);
        log.info("request sent to second service, request: {}", request);

        return new ResponseEntity<>(response, httpStatus);
    }
}
