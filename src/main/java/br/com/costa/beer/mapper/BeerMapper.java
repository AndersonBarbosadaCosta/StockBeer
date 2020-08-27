package br.com.costa.beer.mapper;

import br.com.costa.beer.dto.BeerDTO;
import br.com.costa.beer.entity.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    BeerDTO toDTO(Beer foundBeer);

    Beer toModel(BeerDTO beerDTO);
}