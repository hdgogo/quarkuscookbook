package org.example.basedi.summary;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;

@ApplicationScoped
public class TestEventConsumer {

    /**
     * 消费异步事件，这里故意抛出异常
     */
    public void aSyncConsume(@ObservesAsync TestEvent testEvent) throws Exception {
        throw new Exception("exception from aSyncConsume");
    }
}
