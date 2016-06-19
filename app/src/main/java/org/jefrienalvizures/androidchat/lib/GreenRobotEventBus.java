package org.jefrienalvizures.androidchat.lib;

/**
 * Created by Jefrien Alvizures on 13/06/2016.
 */
public class GreenRobotEventBus implements EventBus {

    org.greenrobot.eventbus.EventBus eventBus;

    private static class SingletoHolder{
        private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
    }

    public static GreenRobotEventBus getInstance(){
        return SingletoHolder.INSTANCE;
    }

    public GreenRobotEventBus(){
        this.eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void untegister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
