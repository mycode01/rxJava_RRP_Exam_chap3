package c3_1.observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Generator {
    // 옵저버를 등록하고 관리하기 위한 list
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer... observers)    // 통지될 옵저버 등록
    {
        for (Observer observer : observers) {
            this.observers.add(observer);
        }
    }

    public void notifyObservers()                // 상태변화를 알리기 위한 메서드
    {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public abstract String getString();

    public abstract void execute() throws IOException;
}