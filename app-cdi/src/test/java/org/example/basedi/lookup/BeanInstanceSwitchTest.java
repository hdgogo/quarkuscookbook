package org.example.basedi.lookup;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@QuarkusTest
public class BeanInstanceSwitchTest {

    @BeforeAll
    public static void setUp() {
        //System.setProperty("service.alpha.enabled", "true");
    }


    // 注意，前面的LookupIfProperty不能决定注入bean是否实例话，只能决定Instance.get是否能取到，
    // 所以此处要注入的是Instance，而不是TryLookupIfProperty本身
    @Inject
    Instance<TryLookupIfProperty> service;

    @Inject
    TryIfBuildProfile tryIfBuildProfile;

    @Test
    public void testTryLookupIfProperty() {
        Assertions.assertEquals("from " + TryLookupIfPropertyAlpha
                        .class.getSimpleName(),
                service.get().hello());
    }

    @Test
    public void tryIfBuildProfile(){
        Assertions.assertEquals("from " + TryIfBuildProfileProd
                        .class.getSimpleName(),
                tryIfBuildProfile.hello());
    }
}
