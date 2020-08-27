package br.com.costa.beer.service;

import br.com.costa.beer.dto.BeerDTO;
import br.com.costa.beer.entity.Beer;
import br.com.costa.beer.exception.BeerAlreadyRegisteredException;
import br.com.costa.beer.exception.BeerNotFoundException;
import br.com.costa.beer.mapper.BeerMapper;
import br.com.costa.beer.reppository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private final BeerRepository repository;

    private final BeerMapper mapperBeer = BeerMapper.INSTANCE;

    @Autowired
    public BeerService(BeerRepository repository) {
        this.repository = repository;
    }

    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        verifyIfAlreadyRegistered(beerDTO.getName());
        Beer beer = mapperBeer.toModel(beerDTO);
        Beer saveBeer = repository.save(beer);
        return mapperBeer.toDTO(saveBeer);
    }

    public BeerDTO findByName(String name) throws BeerNotFoundException {
        Beer foundBeer = this.repository.findByName(name)
                .orElseThrow(() -> new BeerNotFoundException());

        return mapperBeer.toDTO(foundBeer);
    }

    public List<BeerDTO> findAll() {

        return this.repository.findAll()
                .stream()
                .map(mapperBeer::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws BeerNotFoundException {
        verifyIfExists(id);
        repository.deleteById(id);
    }

    private void verifyIfAlreadyRegistered(String name) throws BeerAlreadyRegisteredException {
        var optSaveBeer = this.repository.findByName(name);
        if (optSaveBeer.isPresent()) {
            throw new BeerAlreadyRegisteredException(name);
        }
    }

    private Beer verifyIfExists(Long id) throws BeerNotFoundException {
        return this.repository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }

}
