package br.com.costa.beer.enums;

import lombok.Getter;

@Getter
public enum BeerType {

    LAGER("lager"),
    MALZBIER("malzbier"),
    WITBIER("witbier"),
    WEISS("weiss"),
    ALE("ale"),
    IPA("ipa"),
    STOUT("stout");

    private final String description;

    BeerType(String description) {
        this.description = description;
    }
}
