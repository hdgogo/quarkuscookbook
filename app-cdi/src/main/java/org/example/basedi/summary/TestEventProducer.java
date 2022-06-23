package org.example.basedi.summary;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class TestEventProducer {

    @Inject
    Event<TestEvent> event;



    /**
     * 发送异步事件
     */
    public void asyncProduce() {
        event.fireAsync(new TestEvent());
    }

}
