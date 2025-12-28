package com.techchallenge.dto;

import com.techchallenge.model.Category;
import java.time.LocalDate;

public record FeedbackResponse(
        String fullName,
        String registration,
        Category category,
        String comment,
        LocalDate date,
        Integer rating,
        String id
) {}