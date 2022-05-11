package org.example.app.spi;

import java.util.ServiceLoader;

public class TestSPI {
    public static void main(String[] args) {
        ServiceLoader<Person> loader = ServiceLoader.load(Person.class);
        loader.forEach(Person::walk);
    }
}
