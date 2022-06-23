package org.example.basedi;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClassAnnotationBean {

    public String hello() {
        return "from " + this.getClass().getSimpleName();
    }
}
