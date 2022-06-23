package org.example.basedi.event;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class TwoChannelWithTwoEvent {

    @Inject
    @Admin
    Event<TwoChannelEvent> adminEvent;

    @Inject
    @Normal
    Event<TwoChannelEvent> normalEvent;


    /**
     * 管理员消息
     * @param source
     * @return
     */
    public int produceAdmin(String source) {
        TwoChannelEvent event = new TwoChannelEvent(source);
        adminEvent.fire(event);
        return event.getNum();
    }

    /**
     * 普通消息
     * @param source
     * @return
     */
    public int produceNormal(String source) {
        TwoChannelEvent event = new TwoChannelEvent(source);
        normalEvent.fire(event);
        return event.getNum();
    }
}
