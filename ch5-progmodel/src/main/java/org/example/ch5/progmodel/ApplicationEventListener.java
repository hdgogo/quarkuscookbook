package org.example.ch5.progmodel;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationEventListener.class);

    void onStart(@Observes StartupEvent event){
        logger.info("Application staring.....");
    }

    void onStop(@Observes ShutdownEvent event){
        logger.info("Application shutting donw.....");
    }
}
