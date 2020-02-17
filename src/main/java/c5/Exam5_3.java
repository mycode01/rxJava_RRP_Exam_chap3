package c5;

import io.reactivex.processors.BehaviorProcessor;
import subscriber.DebugSubscriber;

public class Exam5_3 {
    public static void main(String[] args) { // 1 2 3 4 5 를 차례로 통지, BehaviorProcessor는 마지막 항목을 캐시하여 구독자에게 통지함.
//        BehaviorProcessor<Integer> processor = BehaviorProcessor.createDefault(0); // 통지할 데이터가 없을때의 통지할 초기값
        BehaviorProcessor<Integer> processor = BehaviorProcessor.create();
        processor.subscribe(new DebugSubscriber<>("no.1"));

        processor.onNext(1);
        processor.onNext(2);
        processor.onNext(3);

        System.out.println("Subscriber no.2 added");
        processor.subscribe(new DebugSubscriber<>("--- no.2")); // 마지막 데이터(캐시된) 3을 통지받게 됨.

        processor.onNext(4);
        processor.onNext(5);

        processor.onComplete();

        System.out.println("Subscriber no.3 added");
        processor.subscribe(new DebugSubscriber<>("--- no.3")); // 통지할것이 없음. 완료처리
    }
}
