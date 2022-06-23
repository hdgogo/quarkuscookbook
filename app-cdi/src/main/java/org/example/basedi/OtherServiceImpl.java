package org.example.basedi;


public class OtherServiceImpl  implements  HelloService{
    @Override
    public String hello() {
        return "from " + this.getClass().getSimpleName();
    }
}
