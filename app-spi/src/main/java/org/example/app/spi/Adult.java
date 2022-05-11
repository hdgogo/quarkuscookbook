package org.example.app.spi;

public class Adult implements Person{
    @Override
    public void walk() {
        System.out.println("adult is walking");
    }
}
