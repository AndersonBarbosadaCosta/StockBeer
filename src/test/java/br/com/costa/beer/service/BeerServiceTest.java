package br.com.costa.beer.service;

import br.com.costa.beer.builder.BeerDTOBuilder;
import br.com.costa.beer.dto.BeerDTO;
import br.com.costa.beer.entity.Beer;
import br.com.costa.beer.exception.BeerAlreadyRegisteredException;
import br.com.costa.beer.mapper.BeerMapper;
import br.com.costa.beer.reppository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {

    private static final long INVALID_BEER_ID = 1L;

    @Mock
    private BeerRepository beerRepository;

    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    @InjectMocks
    private BeerService beerService;

    @Test
    void whenBeerInformedThenItShouldBeCreated() throws BeerAlreadyRegisteredException {

        // given
        BeerDTO beerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedSaveBeer = beerMapper.toModel(beerDTO);

        // when
        when(beerRepository.findByName(beerDTO.getName())).thenReturn(Optional.empty());
        when(beerRepository.save(expectedSaveBeer)).thenReturn(expectedSaveBeer);

        //then
        BeerDTO createBeerDTO = beerService.createBeer(beerDTO);

        // MatcherAssert --> Hamcrest
        assertThat(createBeerDTO.getId(), is(equalTo(beerDTO.getId())));
        assertThat(createBeerDTO.getName(), is(equalTo(beerDTO.getName())));
        assertThat(createBeerDTO.getQuantity(), is(equalTo(beerDTO.getQuantity())));
        assertThat(createBeerDTO.getQuantity(), is(greaterThan(2)));

        // Assert --> JUNIT
        assertEquals(beerDTO.getId(), createBeerDTO.getId());
        assertEquals(beerDTO.getName(), createBeerDTO.getName());

    }

    @Test
    void whenAlreadyRegisteredBeerInformedThenAnExceptionShouldBeThrow() {

        // given
        BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer duplicatedBeer = beerMapper.toModel(expectedBeerDTO);

        //when
        when(beerRepository.findByName(expectedBeerDTO.getName())).thenReturn(Optional.of(duplicatedBeer));

        //then
        assertThrows(BeerAlreadyRegisteredException.class, () -> beerService.createBeer(expectedBeerDTO));
    }

}
