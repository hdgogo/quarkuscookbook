package org.example.basedi;

public class HelloServiceImpl  implements HelloService{
    @Override
    public String hello() {
        return "from " + this.getClass().getSimpleName();
    }
}
