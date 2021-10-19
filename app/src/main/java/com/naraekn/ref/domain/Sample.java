package com.naraekn.ref.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sample {
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    private String name;

    public Sample() {}

    public Sample(String name) {
        this.name = name;
    }
}
