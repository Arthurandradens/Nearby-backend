package app.nlw.api.Nearby.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressRequest{
        @NotNull
        Double longitude;
        @NotNull
        Double latitude;
        @NotBlank
        String address;
        @NotBlank
        String phone;

        public AddressRequest() {
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
