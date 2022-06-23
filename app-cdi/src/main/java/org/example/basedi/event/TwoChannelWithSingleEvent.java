package org.example.basedi.event;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

@ApplicationScoped
public class TwoChannelWithSingleEvent {

    @Inject
    Event<TwoChannelEvent> singleEvent;


    /**
     * 管理员消息
     * @param source
     * @return
     */
    public int produceAdmin(String source) {
        TwoChannelEvent event = new TwoChannelEvent(source);

        singleEvent.select(new AnnotationLiteral<Admin>() {})
                .fire(event);

        return event.getNum();
    }


    /**
     * 普通消息
     * @param source
     * @return
     */
    public int produceNormal(String source) {
        TwoChannelEvent event = new TwoChannelEvent(source);

        singleEvent.select(new AnnotationLiteral<Normal>() {})
                .fire(event);

        return event.getNum();
    }
}
