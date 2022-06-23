package org.example.basedi.choose;

public class HelloInstanceC implements HelloInstance{
    @Override
    public String hello() {
        return this.getClass().getSimpleName();
    }
}
