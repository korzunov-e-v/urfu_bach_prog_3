package ru.ekorzunov.urfu_bach_prog_3.lr5.service;

import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr5.model.Positions;

@Service
public interface AnnualBonusService {

    double calculate(Positions position, double salary, double bonus, int workDays);

}
