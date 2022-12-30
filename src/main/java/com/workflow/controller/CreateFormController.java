package com.workflow.controller;

import com.workflow.pojo.FormDetailsDto;
import com.workflow.service.FormService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller
public class CreateFormController {

    @Inject
    FormService service;

    @Get("/form")
    public String test() {
        return "test response !";
    }

    @Post("/new-form")
    public String addNewWorkflow(@Body FormDetailsDto formDetails) {
        service.addNewForm(formDetails);
        return "New form added successfully !";
    }
}
