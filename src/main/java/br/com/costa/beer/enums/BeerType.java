package br.com.costa.beer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BeerType {

    LAGER("lager"),
    MALZBIER("malzbier"),
    WITBIER("witbier"),
    WEISS("weiss"),
    ALE("ale"),
    IPA("ipa"),
    STOUT("stout");

    private final String description;

}
