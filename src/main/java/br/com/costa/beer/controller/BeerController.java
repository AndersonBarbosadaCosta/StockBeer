package br.com.costa.beer.controller;

import br.com.costa.beer.dto.BeerDTO;
import br.com.costa.beer.dto.QuantityDTO;
import br.com.costa.beer.exception.BeerAlreadyRegisteredException;
import br.com.costa.beer.exception.BeerNotFoundException;
import br.com.costa.beer.exception.BeerStockExceededException;
import br.com.costa.beer.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController implements BeerControllerDocs {

    private final BeerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        return service.createBeer(beerDTO);
    }

    @GetMapping("/{name}")
    public BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException {
        return service.findByName(name);
    }

    @GetMapping
    public List<BeerDTO> listBeers() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BeerNotFoundException {
        service.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public BeerDTO increment(Long id, @Valid QuantityDTO quantityDTO) throws BeerNotFoundException, BeerStockExceededException {
        return service.increment(id, quantityDTO.getQuantity());
    }

    @PatchMapping("/{id}/decrement")
    public BeerDTO decrement(Long id, @Valid QuantityDTO quantityDTO) throws BeerNotFoundException, BeerStockExceededException {
        return service.decrement(id, quantityDTO.getQuantity());
    }

}
