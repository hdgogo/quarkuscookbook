package org.example.api.reactive;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.*;


@Entity
@Cacheable
public class Fruit extends PanacheEntity {

    @Column(length = 40, unique = true)
    public String name;
}
