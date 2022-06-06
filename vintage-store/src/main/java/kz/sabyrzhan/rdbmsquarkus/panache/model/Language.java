package kz.sabyrzhan.rdbmsquarkus.panache.model;

public enum Language {
    KAZAKH("kk"), ENGLISH("en"), RUSSIAN("ru");

    private String code;

    Language(String code) {
        this.code = code;
    }

    public String getLanguageCode() {
        return code;
    }
}
