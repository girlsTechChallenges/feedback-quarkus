package com.techchallenge.mapper;

import com.techchallenge.dto.FeedbackRequest;
import com.techchallenge.dto.FeedbackResponse;
import com.techchallenge.model.Category;
import com.techchallenge.model.Feedback;

import java.time.LocalDate;

public class FeedbackMapper {

    // Request → Entity
    public static Feedback toEntity(FeedbackRequest request) {
        Feedback feedback = new Feedback();
        feedback.setFullName(request.fullName());
        feedback.setRegistration(request.registration());
        feedback.setCategory(request.category().name());
        feedback.setComment(request.comment());
        feedback.setRating(request.rating());
        return feedback;
    }

    public static FeedbackResponse toResponse(Feedback feedback) {
        if (feedback == null) return null;

        return new FeedbackResponse(
                feedback.getFullName(),
                feedback.getRegistration(),
                Category.valueOf(feedback.getCategory()),
                feedback.getComment(),
                LocalDate.now(),
                feedback.getRating(),
                feedback.getId()
        );
    }
}