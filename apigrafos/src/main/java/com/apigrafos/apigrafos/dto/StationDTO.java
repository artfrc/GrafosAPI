package com.apigrafos.apigrafos.dto;

import jakarta.validation.constraints.NotBlank;

public record StationDTO(

    @NotBlank(message = "Empty name field")
    String name

) {
    
}
