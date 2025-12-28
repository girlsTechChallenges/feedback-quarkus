package com.techchallenge.service;

import com.techchallenge.dto.FeedbackRequest;
import com.techchallenge.dto.FeedbackResponse;
import com.techchallenge.mapper.FeedbackMapper;
import com.techchallenge.model.Feedback;
import com.techchallenge.repository.FeedbackRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class FeedbackService {

    @Inject
    FeedbackRepository repository;

    @Transactional
    public FeedbackResponse createFeedback(FeedbackRequest request) {
        Feedback feedback = FeedbackMapper.toEntity(request);
        feedback.setId(UUID.randomUUID().toString());
        repository.save(feedback);
        return FeedbackMapper.toResponse(feedback);
    }

    public List<FeedbackResponse> getAllFeedbacks() {
        return repository.getAll()
                .stream()
                .map(FeedbackMapper::toResponse)
                .toList();
    }

    public FeedbackResponse getFeedbackById(String id) {
        Feedback feedback = repository.findById(id);
        return feedback != null ? FeedbackMapper.toResponse(feedback) : null;
    }

    @Transactional
    public FeedbackResponse updateFeedback(String id, FeedbackRequest request) {
        Feedback feedback = FeedbackMapper.toEntity(request);
        feedback.setId(id);
        repository.update(feedback);
        return FeedbackMapper.toResponse(feedback);
    }

    @Transactional
    public void deleteFeedback(String id) {
        repository.delete(id);
    }
}