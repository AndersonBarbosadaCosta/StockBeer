package br.com.costa.beer.controller;

import br.com.costa.beer.dto.BeerDTO;
import br.com.costa.beer.dto.QuantityDTO;
import br.com.costa.beer.exception.BeerAlreadyRegisteredException;
import br.com.costa.beer.exception.BeerNotFoundException;
import br.com.costa.beer.exception.BeerStockExceededException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api("Manages beer stock")
public interface BeerControllerDocs {

    @ApiOperation(value = "Beer creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success beer creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException;

    @ApiOperation(value = "Returns beer found by a given name ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success beer found in the system"),
            @ApiResponse(code = 404, message = "Beer with given name not found.")
    })
    BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException;

    List<BeerDTO> listBeers();

    @ApiOperation(value = "Delete a beer found by a given valid id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success beer deleted in the system"),
            @ApiResponse(code = 404, message = "Beer with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws BeerNotFoundException;

    @ApiOperation(value = "Increment beer by a given id quantity in a stock")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success beer incremented in stock"),
            @ApiResponse(code = 400, message = "Beer not successfully increment in stock."),
            @ApiResponse(code = 404, message = "Beer with given id not found.")
    })
    BeerDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws BeerNotFoundException,
            BeerStockExceededException;

    @ApiOperation(value = "Decrement beer by a given id quantity in a stock")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success beer decremented in stock"),
            @ApiResponse(code = 400, message = "Beer not successfully increment in stock"),
            @ApiResponse(code = 404, message = "Beer with given id not found.")
    })
    BeerDTO decrement(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws BeerNotFoundException, BeerStockExceededException;
}
