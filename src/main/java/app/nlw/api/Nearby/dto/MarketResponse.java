package app.nlw.api.Nearby.dto;

import app.nlw.api.Nearby.model.Market;

import java.util.UUID;
public record MarketResponse(
                UUID id,
                UUID categoryId,
                String name,
                String description,
                Integer coupons,
                Double longitude,
                Double latitude,
                String address,
                String phone,
                String cover
) {
    public MarketResponse(Market market) {
        this(
                market.getId(),
                market.getCategory().getId(),
                market.getName(),
                market.getDescription(),
                market.getCoupons(),
                market.getAddress().getLongitude(),
                market.getAddress().getLatitude(),
                market.getAddress().getAddress(),
                market.getAddress().getPhone(),
                market.getCover()
        );
    }
}
