package com.example.Custom.Queries1.entity;

public enum FlightStatus {
    ONTIME,
    DELAYED,
    CANCELLED;


    public static FlightStatus toString(String status) {
        return switch (status.toLowerCase()) {
            case "delayed" -> FlightStatus.DELAYED;
            case "cancelled" -> FlightStatus.CANCELLED;
            default -> FlightStatus.ONTIME;
        };
}
}
