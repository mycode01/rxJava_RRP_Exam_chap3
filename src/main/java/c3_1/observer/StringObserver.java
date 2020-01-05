package c3_1.observer;

public class StringObserver implements Observer {
    String Message;

    public void update(Generator generator) {
        Message = generator.getString();        // 상태정보 데이터(메시지) 가져옴
        System.out.println("c3_1.observer.StringObserver : " + Message); //화면에 출력
    }
}