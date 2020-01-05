package c3_1.observer;

public class StringCountObserver implements Observer {
    int count;

    public void update(Generator generator) {
        count = generator.getString().length();        // 상태정보데이터(메시지)를 가져와 갯수 저장
        System.out.println("c3_1.observer.StringCountObserver : " + count);
    }
}