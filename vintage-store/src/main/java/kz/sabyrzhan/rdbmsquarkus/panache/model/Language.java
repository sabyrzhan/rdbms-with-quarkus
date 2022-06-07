package kz.sabyrzhan.rdbmsquarkus.panache.model;

public enum Language {
    KAZAKH("kk"), ENGLISH("en"), RUSSIAN("ru"), FRENCH("fr"),
    GERMAN("de"), CHINESE("cn"), JAPANESE("jp"), SPANISH("esp"),
    PORTUGUESE("por"), INDIAN("in");

    private String code;

    Language(String code) {
        this.code = code;
    }

    public String getLanguageCode() {
        return code;
    }
}
