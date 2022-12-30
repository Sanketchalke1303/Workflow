package com.workflow.controller;

import com.workflow.pojo.WorkflowDetailsDto;
import com.workflow.service.WorkflowService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller
public class WorkflowController {

    @Inject
    WorkflowService service;

    @Get("/")
    public String test() {
        return "test response !";
    }

    @Post("/add-workflow")
    public String addNewWorkflow(@Body WorkflowDetailsDto workflow) {
        service.addNewWorkflow(workflow);
        return "New workflow added successfully !";
    }

    @Get("/all-workflows")
    public List<WorkflowDetailsDto> getAllWorkflows() {
        return service.getAllWorkflows();
    }

}
