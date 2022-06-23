package org.example.basedi.event;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;


@ApplicationScoped
public class MyProducer {

    @Inject
    Event<MyEvent> event;

    /**
     * 发送同步消息
     *
     * @param source 消息源
     * @return 被消费次数
     */
    public int syncProduce(String source) {
        MyEvent myEvent = new MyEvent("syncEvent");
        Log.infov("before sync fire, {0}", myEvent);
        event.fire(myEvent);
        Log.infov("after sync fire, {0}", myEvent);
        return myEvent.getNum();
    }


    /**
     * 发送异步消息
     *
     * @param source
     * @return
     */
    public int asyncProduce(String source) {
        MyEvent myEvent = new MyEvent(source);
        Log.infov("before async fire, {0}", myEvent);
        event.fireAsync(myEvent)
                .handleAsync((e, error) -> {
                    if (null != error) {
                        Log.error("handle error", error);
                    } else {
                        Log.infov("finish handle, {0}", myEvent);
                    }

                    return null;
                });
        Log.infov("after async fire, {0}", myEvent);
        return myEvent.getNum();
    }
}
