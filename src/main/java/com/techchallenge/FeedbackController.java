package com.techchallenge;

import com.techchallenge.dto.FeedbackRequest;
import com.techchallenge.dto.FeedbackResponse;
import com.techchallenge.service.FeedbackService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/feedback")
public class FeedbackController {

    @Inject
    FeedbackService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid FeedbackRequest request) {
        FeedbackResponse response = service.createFeedback(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<FeedbackResponse> feedbacks = service.getAllFeedbacks();
        return Response.ok(feedbacks).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) {
        FeedbackResponse feedback = service.getFeedbackById(id);
        if (feedback == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(feedback).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, @Valid FeedbackRequest request) {
        FeedbackResponse response = service.updateFeedback(id, request);
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) {
        service.deleteFeedback(id);
        return Response.noContent().build();
    }
}