package ru.ekorzunov.urfu_bach_prog_3.lr5.service;

import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr5.model.Positions;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {

    @Override
    public double calculate(Positions position, double salary, double bonus, int workDays) {
        return salary * bonus * getDaysInYear() * position.getPositionCoefficient() / workDays;
    }

    public double calculateQuarterBonus(Positions position, double salary, double bonus, int workDays, int quarter, int year) {
        if (position.isManager()) {
            return salary * bonus * position.getPositionCoefficient() * getDaysInQuarter(quarter, year) / workDays;
        } else {
            return 0;
        }
    }

    static int getDaysInYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.getMaximum(GregorianCalendar.DAY_OF_YEAR);
    }

    static int getDaysInQuarter(int quarter, int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);

        int daysInQuarter = 0;

        switch (quarter) {
            case 1 -> daysInQuarter = calendar.isLeapYear(year) ? 91 : 90;
            case 2 -> daysInQuarter = 91;
            case 3, 4 -> daysInQuarter = 92;
        }

        return daysInQuarter;
    }

}
