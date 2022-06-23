package org.example.basedi.choose;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloInstanceA implements HelloInstance{
    @Override
    public String hello() {
        return this.getClass().getSimpleName();
    }
}
