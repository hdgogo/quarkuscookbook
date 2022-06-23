package org.example.basedi.choose;


import io.quarkus.arc.Priority;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@ApplicationScoped
//@Named("B")
@Alternative
@Priority(999)
public class HelloQualifierB implements HelloQualifier{
    @Override
    public String hello() {
        return "Hello " + this.getClass().getSimpleName();
    }
}
