package br.com.costa.beer.exception;

public class BeerStockExceededException extends Exception {

    public BeerStockExceededException(Long id, int quantityToIncrement) {
        super(String.format("Beers with %s ID to increment informed exceeds the max stock capacity:" +
                "%s", id, quantityToIncrement));
    }
}
