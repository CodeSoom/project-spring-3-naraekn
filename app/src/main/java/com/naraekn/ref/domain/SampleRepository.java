package com.naraekn.ref.domain;

import java.util.List;

public interface SampleRepository {
    List<Sample> findAll();

    Sample save(Sample sample);
}
