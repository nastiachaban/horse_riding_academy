package com.example.school.entities.enums;

public enum Gender {
    MALE("M"),
    FEMALE("F"),
    DIVERSE("D");

    private final String code;

    Gender(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public static Gender fromCode(String code) {
        for (Gender status : Gender.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown gender: " + code);
    }
}
