package ru.ekorzunov.urfu_bach_prog_3.lr5.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank
    @Size(max = 32)
    private String uid; // Уникальный идентификатор сообщение

    @NotBlank
    @Size(max = 32)
    private String operationUid; // Уникальный идентификатор операции

    private String systemName; // Имя системы отправителя
    private String systemTime; // Время создания сообщения
    private String source; // Наименование ресурса

    private Positions position; // Должность
    private Double salary; // Заработная плата
    private Double bonus; // Бонус
    private Integer workDays; // Кол-во рабочих дней

    @Min(1)
    @Max(100000)
    private int communicationId; // Уникальный идентификатор коммуникации

    private int templateId; // Уникальный идентификатор шаблона
    private int productCode; // Код продукта
    private int smsCode; // Смс код

    @Override
    public String toString() {
        return "Request{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}
