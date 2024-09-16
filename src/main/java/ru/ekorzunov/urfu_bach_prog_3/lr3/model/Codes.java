package ru.ekorzunov.urfu_bach_prog_3.lr3.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Codes {

    SUCCESS("success"),
    FAILED("failed");

    private final String name;

    Codes(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
