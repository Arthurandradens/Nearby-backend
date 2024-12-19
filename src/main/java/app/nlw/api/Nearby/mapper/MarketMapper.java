package app.nlw.api.Nearby.mapper;

import app.nlw.api.Nearby.dto.AddressRequest;
import app.nlw.api.Nearby.dto.MarketRequest;
import app.nlw.api.Nearby.model.Address;
import app.nlw.api.Nearby.model.Category;
import app.nlw.api.Nearby.model.Market;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MarketMapper {

    MarketMapper INSTANCE = Mappers.getMapper(MarketMapper.class);

    Market marketRequestToMarket(MarketRequest request, Category category);
    Address addressRequestToAddress(AddressRequest request);


}
