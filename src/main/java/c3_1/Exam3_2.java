package c3_1;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

public class Exam3_2 {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber<String>() {
            private List<String> list = new ArrayList<>();

            @Override
            public void onNext(String s) {
                if (list.size() <= 5) { // 원자성을 보장하지 않기때문에 아래 라인이 실행될 시점에는 결과값이 다를수 있음.
                    list.add(s);
                }
            }

            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }


        };
    }
}
