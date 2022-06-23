package org.example.basedi.decorator;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Espresso implements  Coffee {
    @Override
    public String name() {
        return "Espresso";
    }

    @Override
    public int getPrice() {
        return 3;
    }
}
