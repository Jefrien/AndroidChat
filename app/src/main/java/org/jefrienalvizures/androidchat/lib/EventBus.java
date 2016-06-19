package org.jefrienalvizures.androidchat.lib;

/**
 * Created by Jefrien Alvizures on 13/06/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void untegister(Object subscriber);
    void post(Object event);
}
