package app.nlw.api.Nearby.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CategoryRequest(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Záéíóúãõâêîôûàèìòùäëïöü]+$")
        String name
) {
}
