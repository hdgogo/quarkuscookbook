package org.example.basedi.event;

import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;


@ApplicationScoped
public class MyConsumer {

    /**
     * 消费同步事件
     * @param myEvent
     */
    public void syncConsume(@Observes MyEvent myEvent) {
        Log.infov("receive sync event, {0}", myEvent);

        // 模拟业务执行，耗时100毫秒
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 计数加一
        myEvent.addNum();
    }


    /**
     * 消费异步事件
     * @param myEvent
     */
    public void aSyncConsume(@ObservesAsync MyEvent myEvent) {
        Log.infov("receive async event, {0}", myEvent);

        // 模拟业务执行，耗时100毫秒
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 计数加一
        myEvent.addNum();
    }
}
