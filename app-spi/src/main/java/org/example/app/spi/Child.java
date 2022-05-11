package org.example.app.spi;

public class Child  implements  Person{
    @Override
    public void walk() {
        System.out.println("child is walking");
    }
}
