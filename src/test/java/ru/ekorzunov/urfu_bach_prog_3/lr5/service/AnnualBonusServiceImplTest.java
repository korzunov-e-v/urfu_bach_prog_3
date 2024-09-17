package ru.ekorzunov.urfu_bach_prog_3.lr5.service;

import org.junit.jupiter.api.Test;
import ru.ekorzunov.urfu_bach_prog_3.lr5.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {

        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        double result = new AnnualBonusServiceImpl().calculate(position, salary, bonus, workDays);
        double expected = 360493.8271604938;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterBonus() {
        Positions position = Positions.PM;
        double bonus = 2.0;
        int workDays = 63;
        double salary = 100000.00;
        int quarter = 1;
        int year = 2024;

        double result = new AnnualBonusServiceImpl().
                calculateQuarterBonus(position, salary, bonus, workDays, quarter, year);
        double expected = 751111.1111111111;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterBonusZero() {
        Positions position = Positions.DEV;
        double bonus = 2.0;
        int workDays = 63;
        double salary = 101000.00;
        int quarter = 1;
        int year = 2024;

        double result = new AnnualBonusServiceImpl().
                calculateQuarterBonus(position, salary, bonus, workDays, quarter, year);
        double expected = 0.0;

        assertThat(result).isEqualTo(expected);
    }
}