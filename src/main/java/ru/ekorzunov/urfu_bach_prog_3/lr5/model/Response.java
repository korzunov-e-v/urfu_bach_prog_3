package ru.ekorzunov.urfu_bach_prog_3.lr5.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Response {

    private String uid; // Уникальный идентификатор сообщение
    private String operationUid; // Уникальный идентификатор операции
    private String systemTime; // Время создания сообщения
    private Codes code; // Код успешности выполнения
    private Double annualBonus; // Годовая премия
    private ErrorCodes errorCode; // Код ошибки
    private ErrorMessages errorMessage; // Сообщение ошибки

}
