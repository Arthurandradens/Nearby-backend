package app.nlw.api.Nearby.model;

import app.nlw.api.Nearby.dto.MarketRequest;
import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "markets")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private Integer coupons;

    @Embedded
    private Address address;
    private String cover;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Market() {
    }

    public Market(MarketRequest request, Category category) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.address = new Address(request.getAddress());
        this.cover = request.getCover();
        this.coupons = request.getCoupons();
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCoupons() {
        return coupons;
    }

    public Address getAddress() {
        return address;
    }

    public String getCover() {
        return cover;
    }

    public Category getCategory() {
        return category;
    }

    public boolean useCoupon() {
        if (this.coupons > 0){
            this.coupons = this.coupons - 1;
            return true;
        } else {
            return false;
        }
    }
}
