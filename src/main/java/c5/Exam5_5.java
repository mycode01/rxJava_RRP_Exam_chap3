package c5;

import io.reactivex.processors.AsyncProcessor;
import subscriber.DebugSubscriber;

public class Exam5_5 {
    public static void main(String[] args) { // 1 2 3 4 5 를 차례로 통지하지만, AsyncProcessor는 마지막 데이터만을 캐시하여 통지함.
        AsyncProcessor<Integer> processor = AsyncProcessor.create();

        processor.subscribe(new DebugSubscriber<>("no.1")); // 통지데이터 없을때 구독

        processor.onNext(1);
        processor.onNext(2);
        processor.onNext(3);

        System.out.println("Subscriber no.2 added");
        processor.subscribe(new DebugSubscriber<>("--- no.2")); // 아직 완료되지 않아 1 2 3이 있지만 통지받지 못함

        processor.onNext(4);
        processor.onNext(5);

        processor.onComplete(); // 마지막 항목인 5를 통지하며 완료

        System.out.println("Subscriber no.3 added");
        processor.subscribe(new DebugSubscriber<>("--- no.3")); // 마지막 항목인 5를 통지받음

    }

}
