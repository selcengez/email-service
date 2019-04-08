package com.example.poc.dto;

public class RestErrorMessage {
    private final String message;
    private final String i18nId;
    private final String debugId;

    public RestErrorMessage(String message, String i18nId, String debugId) {
        this.message = message;
        this.i18nId = i18nId;
        this.debugId = debugId;
    }

    public String getMessage() {
        return message;
    }

    public String getI18nId() {
        return i18nId;
    }

    public String getDebugId() {
        return debugId;
    }
}
