package com.ubang.util;

import java.util.Observable;

public class BaseObservable extends Observable {

    private static volatile BaseObservable observable;

    private BaseObservable() {
    }

    public static synchronized BaseObservable getBaseObservable() {
        if (observable == null) {
            observable = new BaseObservable();
        }
        return observable;
    }


    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
        this.setChanged();
    }
}