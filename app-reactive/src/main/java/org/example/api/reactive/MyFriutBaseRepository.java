package org.example.api.reactive;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyFriutBaseRepository implements PanacheRepository<MyFruit> {
}
