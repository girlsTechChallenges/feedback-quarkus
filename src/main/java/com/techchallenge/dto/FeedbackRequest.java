package com.techchallenge.dto;

import com.techchallenge.model.Category;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FeedbackRequest(
        @NotBlank String fullName,
        @NotBlank String registration,
        @NotNull Category category,
        @NotBlank String comment,
        @NotNull @Min(0) @Max(5) Integer rating
) {}
