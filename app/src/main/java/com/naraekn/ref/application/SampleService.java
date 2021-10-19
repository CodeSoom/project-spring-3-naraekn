package com.naraekn.ref.application;

import com.naraekn.ref.domain.Sample;
import com.naraekn.ref.domain.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {
    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public List<Sample> getSamples() {
        return sampleRepository.findAll();
    }

    public Sample createSample(String name) {
        return sampleRepository.save(new Sample(name));
    }
}
