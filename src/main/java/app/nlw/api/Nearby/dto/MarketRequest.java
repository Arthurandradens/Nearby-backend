package app.nlw.api.Nearby.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class MarketRequest{
        @NotBlank
        String name;
        @NotBlank
        String description;
        @NotNull
        Integer coupons;
        @NotNull
        @Valid
        AddressRequest address;
        @NotBlank
        String cover;
        @NotNull
        UUID categoryId;

        public MarketRequest() {

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

        public AddressRequest getAddress() {
                return address;
        }

        public String getCover() {
                return cover;
        }

        public UUID getCategoryId() {
                return categoryId;
        }
}
