package app.nlw.api.Nearby.dto;

import app.nlw.api.Nearby.model.Market;

import java.util.List;
import java.util.UUID;

public record MarketDetailsResponse(
                UUID id,
                UUID categoryId,
                String name,
                String description,
                Integer coupons,
                Double longitude,
                Double latitude,
                String address,
                String phone,
                String cover,
                List<RuleResponse> rule

) {
    public MarketDetailsResponse(Market market, List<RuleResponse> rules) {
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
                market.getCover(),
                rules

        );
    }
}
