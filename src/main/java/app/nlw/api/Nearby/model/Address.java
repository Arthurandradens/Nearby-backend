package app.nlw.api.Nearby.model;

import app.nlw.api.Nearby.dto.AddressRequest;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private Double longitude;
    private Double latitude;
    private String address;
    private String phone;

    public Address() {}

    public Address(AddressRequest address) {
        this.latitude = address.getLatitude();
        this.longitude = address.getLongitude();
        this.address = address.getAddress();
        this.phone = address.getPhone();
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
