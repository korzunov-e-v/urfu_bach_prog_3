package ru.ekorzunov.urfu_bach_prog_3.lr5.model;

import lombok.Getter;

@Getter
public enum Positions {

    DEV("Developer", 2.2, false),
    HR("Human Resources Specialist", 1.2, false),
    TL("Team Lead", 2.6, true),
    PM("Project Manager", 2.6, true),
    QA("Quality Assurance", 2.2, false),
    BA("Business Analyst", 2.2, false);


    private final String name;
    private final double positionCoefficient;
    private final boolean isManager;

    Positions(String name, double positionCoefficient, boolean isManager) {
        this.name = name;
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}
