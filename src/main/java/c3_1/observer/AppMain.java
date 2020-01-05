package c3_1.observer;

import java.io.IOException;

public class AppMain {
    public static void main(String[] args) throws IOException {
        Observer printObserver = new StringObserver(); // 입력받은 데이터를 출력 할 옵저버
        Observer counterObserver = new StringCountObserver(); // 입력받은 데이터 갯수를 출력할 옵저버

        Generator generator = new StringGenerator(); // 관찰대상

        generator.addObserver(printObserver, counterObserver); // 옵저버 등록

        generator.execute();
    }
}
