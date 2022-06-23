package org.example.basedi.choose;

import io.quarkus.arc.Priority;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
@Priority(998)
public class HelloQualifierC implements HelloQualifier{
    @Override
    public String hello() {
        return "Hello " + this.getClass().getSimpleName();
    }
}
