package ru.ekorzunov.urfu_bach_prog_3.lr4.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Response {

    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;

}
