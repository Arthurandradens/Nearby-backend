package app.nlw.api.Nearby.model;

import app.nlw.api.Nearby.dto.RuleRequest;
import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "rules")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private Market market;

    public Rule() {
    }

    public Rule(RuleRequest request, Market market) {
        this.description = request.description();
        this.market = market;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Market getMarket() {
        return market;
    }

}
