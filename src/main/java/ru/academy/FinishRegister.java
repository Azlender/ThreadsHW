package ru.academy;

import java.util.concurrent.atomic.AtomicInteger;

public class FinishRegister {
    private final AtomicInteger finishOrder = new AtomicInteger(1);//четчик для бегунов
    private String firstFinisher;
    private String lastFinisher;

    //зарегестриовать финишировавшего
    public synchronized void register(String name) {
        int order = finishOrder.getAndIncrement();
        if (order == 1) {
            firstFinisher = name;
        }
        lastFinisher = name;
    }

    //узнать победителя
    public String getFirstFinisher() {
        return firstFinisher;
    }
//узнать аутсайдера
    public String getLastFinisher() {
        return lastFinisher;
    }
}

