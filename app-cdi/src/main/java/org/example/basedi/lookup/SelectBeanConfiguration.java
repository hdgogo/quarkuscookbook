package org.example.basedi.lookup;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.lookup.LookupIfProperty;
import io.quarkus.arc.lookup.LookupUnlessProperty;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.arc.profile.UnlessBuildProfile;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class SelectBeanConfiguration {

    @LookupIfProperty(name = "service.alpha.enabled", stringValue = "true" , lookupIfMissing = true)
    @ApplicationScoped
    public TryLookupIfProperty tryLookupIfPropertyAlpha(){
        return new TryLookupIfPropertyAlpha();
    }

    //@LookupIfProperty(name = "service.beta.enabled", stringValue = "true")
    @LookupUnlessProperty(name="service.alpha.enabled", stringValue = "true")
    @ApplicationScoped
    public TryLookupIfProperty tryLookupIfPropertyBeta() {
        return new TryLookupIfPropertyBeta();
    }


    @Produces
    //@IfBuildProfile("test")
    @UnlessBuildProfile("prod")
    public TryIfBuildProfile tryIfBuildProfileProd() {
        return new TryIfBuildProfileProd();
    }

    @Produces
    @DefaultBean
    public TryIfBuildProfile tryIfBuildProfileDefault() {
        return new TryIfBuildProfileDefault();
    }

}
