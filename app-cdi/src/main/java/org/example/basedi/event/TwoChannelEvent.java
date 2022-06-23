package org.example.basedi.event;

import java.util.concurrent.atomic.AtomicInteger;

public class TwoChannelEvent {

    /**
     * 事件源
     */
    private String source;

    /**
     * 事件被消费的总次数
     */
    private AtomicInteger consumeNum;

    public TwoChannelEvent(String source) {
        this.source = source;
        consumeNum = new AtomicInteger();
    }

    /**
     * 事件被消费次数加一
     * @return
     */
    public int addNum() {
        return consumeNum.incrementAndGet();
    }

    /**
     * 获取事件被消费次数
     * @return
     */
    public int getNum() {
        return consumeNum.get();
    }

    @Override
    public String toString() {
        return "TwoChannelEvent{" +
                "source='" + source + '\'' +
                ", consumeNum=" + getNum() +
                '}';
    }
}
