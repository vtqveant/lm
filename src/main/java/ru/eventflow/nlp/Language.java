package ru.eventflow.nlp;

public enum Language {

    BS("bs", "Bosnian"),
    HR("hr", "Croatian"),
    SR("sr", "Serbian"),
    ID("id", "Indonesian"),
    MY("my", "Malay"),
    PT_BR("pt-BR", "Brazilian Portuguese"),
    PT_PT("pt-PT", "European Portuguese"),
    ES_AR("es-AR", "Argentine Spanish"),
    ES_ES("es-ES", "Castilian Spanish"),
    ES_PE("es-PE", "Peruvian Spanish"),
    FR_CA("fr-CA", "Canadian French"),
    FR_FR("fr-FR", "Hexagonal French"),
    FA_IR("fa-IR", "Persian"),
    FA_AF("fa-AF", "Dari");

    private String code;
    private String description;

    Language(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
