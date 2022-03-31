package org.example.ch5.progmodel;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MariaDBContainer;

import java.util.HashMap;
import java.util.Map;


@QuarkusTestResource(MariaDbTestResource.Initializer.class)  //注册 test resource
public class MariaDbTestResource {

    public static class Initializer implements QuarkusTestResourceLifecycleManager{ //定义test resource接口

        private MariaDBContainer mariaDBContainer; //设置mariadb 容器

        @Override
        public Map<String, String> start() {
            this.mariaDBContainer = new MariaDBContainer<>("mariadb:latest"); //用所需的Docker镜像实例化MariaDb容器
            this.mariaDBContainer.start();
            return getConfigurationParameters();
        }

        private Map<String, String> getConfigurationParameters(){ //覆盖Quarkus的配置，将数据库指向容器
            final  Map<String, String> conf = new HashMap<>();
            conf.put("quarkus.datasource.url", this.mariaDBContainer.getJdbcUrl());
            conf.put("qurakus.datasource.username", this.mariaDBContainer.getUsername());
            conf.put("quarkus.datasource.password", this.mariaDBContainer.getPassword());
            conf.put("quarus.datasource.driver", this.mariaDBContainer.getDriverClassName());
            return conf;
        }

        @Override
        public void stop() {
            if(this.mariaDBContainer != null){
                this.mariaDBContainer.close();
            }
        }
    }
}
