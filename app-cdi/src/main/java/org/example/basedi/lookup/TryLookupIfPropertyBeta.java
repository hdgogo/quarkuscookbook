package org.example.basedi.lookup;

public class TryLookupIfPropertyBeta implements TryLookupIfProperty{
    @Override
    public String hello() {
        return "from " + this.getClass().getSimpleName();
    }
}
