package org.example.basedi.lookup;

public class TryIfBuildProfileProd implements TryIfBuildProfile{
    @Override
    public String hello() {
        return "from " + this.getClass().getSimpleName();
    }
}
