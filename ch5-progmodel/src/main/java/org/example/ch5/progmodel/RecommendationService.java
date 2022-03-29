package org.example.ch5.progmodel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class RecommendationService {

    List<String> products;

    @PostConstruct
    public void init(){
        products = Arrays.asList("Orange","Apple","Mango");
        System.out.println("products initialized");
    }

    @PreDestroy
    public void cleanup(){
        products = null;
        System.out.println("products clean up");
    }

    public List<String> getProducts() {
        return products;
    }
}
