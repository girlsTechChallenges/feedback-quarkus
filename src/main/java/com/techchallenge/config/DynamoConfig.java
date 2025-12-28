package com.techchallenge.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import com.techchallenge.model.Feedback;

@ApplicationScoped
public class DynamoConfig {

    @Produces
    @ApplicationScoped
    public DynamoDbTable<Feedback> feedbackTable(DynamoDbEnhancedClient enhancedClient) {
        return enhancedClient.table("feedback", TableSchema.fromBean(Feedback.class));
    }
}