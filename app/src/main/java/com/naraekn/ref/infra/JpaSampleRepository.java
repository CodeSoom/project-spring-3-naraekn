package com.naraekn.ref.infra;

import com.naraekn.ref.domain.Sample;
import com.naraekn.ref.domain.SampleRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaSampleRepository
        extends SampleRepository, CrudRepository<Sample, Long>{
    List<Sample> findAll();

    Sample save(Sample sample);
}
