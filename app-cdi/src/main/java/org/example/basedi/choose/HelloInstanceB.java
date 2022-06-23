package org.example.basedi.choose;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloInstanceB implements HelloInstance{
    @Override
    public String hello() {
        return this.getClass().getSimpleName();
    }
}
