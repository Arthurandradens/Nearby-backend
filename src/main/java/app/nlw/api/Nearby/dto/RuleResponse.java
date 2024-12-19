package app.nlw.api.Nearby.dto;

import app.nlw.api.Nearby.model.Rule;

import java.util.UUID;

public record RuleResponse(
        UUID id,
        String description,
        UUID marketId
) {
    public RuleResponse(Rule rule,UUID id){
        this(rule.getId(),rule.getDescription(),id);
    }
}
