package com.apigrafos.apigrafos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RouteDTO(

    @NotBlank(message = "Empty source field")
    String source,

    @NotBlank(message = "Empty destiny field")
    String destiny,

    @NotNull(message = "Empty distance field")
    Float distance

) {
    
}
