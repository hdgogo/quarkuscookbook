package org.example.basedi.choose;

import io.quarkus.arc.Priority;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
//@MyQualifier("")
@Alternative
@Priority(1000)
public class HelloQualifierA implements HelloQualifier{
    @Override
    public String hello() {
        return "Hello " + this.getClass().getSimpleName();
    }
}
