package com.exemple.coach.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public record IngestionRequest(
        @NotBlank String theme,
        @NotBlank @Size(max = 100000) String texte) {}

