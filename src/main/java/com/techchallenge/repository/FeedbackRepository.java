package com.techchallenge.repository;

import com.techchallenge.model.Feedback;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

@ApplicationScoped
public class FeedbackRepository {

    private final DynamoDbTable<Feedback> table;

    @Inject
    public FeedbackRepository(DynamoDbEnhancedClient enhancedClient) {
        this.table = enhancedClient.table("feedback", TableSchema.fromBean(Feedback.class));
    }

    public void save(Feedback feedback) {
        table.putItem(feedback);
    }

    public List<Feedback> getAll() {
        return table.scan()
                .items()
                .stream()
                .toList();
    }

    public Feedback findById(String id) {
        return table.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    public void update(Feedback feedback) {
        table.updateItem(feedback);
    }

    public void delete(String id) {
        table.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}