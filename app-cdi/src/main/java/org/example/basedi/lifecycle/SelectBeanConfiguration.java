package org.example.basedi.lifecycle;

import io.quarkus.logging.Log;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;

public class SelectBeanConfiguration {

    @RequestScoped
    public ResourceManager getResourceManager() {
        return new ResourceManager();
    }


    /**
     * 使用了Disposes注解后，ResourceManager类型的bean在销毁前，此方法都会执行
     * @param resourceManager
     */
    public void closeResource(@Disposes ResourceManager resourceManager) {
        // 在这里可以做一些额外的操作，不需要bean参与
        Log.info("do other things that bean do not care");

        // 也可以执行bean的方法
        resourceManager.closeAll();
    }
}
