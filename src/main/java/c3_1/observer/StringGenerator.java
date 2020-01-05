package c3_1.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringGenerator extends Generator {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private String message;        // 상태값으로 이용될 데이터

    public String getString()    // 데이터 getter
    {
        return this.message;
    }

    public void execute() throws IOException {
        while (true) {
            message = in.readLine();    // 상태 정보 변경
            if ("exit".equals(message)) {
                break;
            }
            notifyObservers();            // 통지
        }
    }
}