package com.exemple.coach.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ReponseRequest(
        @NotBlank String theme,
        @NotBlank @Size(max = 1000) String question,
        @NotBlank @Size(max = 4000) String reponse) {}