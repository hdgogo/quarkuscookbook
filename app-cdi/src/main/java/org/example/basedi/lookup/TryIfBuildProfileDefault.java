package org.example.basedi.lookup;

public class TryIfBuildProfileDefault implements TryIfBuildProfile {
    @Override
    public String hello() {
        return "from " + this.getClass().getSimpleName();
    }
}
