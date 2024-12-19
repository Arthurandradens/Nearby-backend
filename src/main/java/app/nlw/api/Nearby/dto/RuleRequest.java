package app.nlw.api.Nearby.dto;

import java.util.UUID;

public record RuleRequest(
        String description,
        UUID marketId
) {
}
