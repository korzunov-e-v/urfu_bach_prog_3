package ru.ekorzunov.urfu_bach_prog_3.lr3.model;

public enum Systems {

    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");

    private final String description;

    Systems(String description) {
        this.description = description;
    }

    public String getName() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
