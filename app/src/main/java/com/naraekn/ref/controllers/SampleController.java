package com.naraekn.ref.controllers;

import com.naraekn.ref.application.SampleService;
import com.naraekn.ref.domain.Sample;
import com.naraekn.ref.dto.SampleData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sample")
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public List<Sample> getSamples() {
        return sampleService.getSamples();
    }

    @PostMapping
    public Sample createSample(@RequestBody SampleData sampleData) {
        return sampleService.createSample(sampleData.getName());
    }
}
