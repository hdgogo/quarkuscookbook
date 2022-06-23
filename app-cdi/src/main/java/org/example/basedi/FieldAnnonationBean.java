package org.example.basedi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class FieldAnnonationBean {

    @Produces
    @FieldAnn
    @ApplicationScoped
    OtherServiceImpl otherServiceImpl = new OtherServiceImpl();

}
