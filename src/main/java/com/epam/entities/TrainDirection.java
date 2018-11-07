package com.epam.entities;

public enum TrainDirection {
    EAST("east"), WEST("west");

    private String value;

    TrainDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
